package com.alphaone.example.ui.book.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alphaone.example.ui.book.model.Book;

/**
 * Service APIs that communicate with Book microservice REST API to access data.
 * 
 * Service can communicate with each other via direct URL (testing) or using discovery service (EurekaServer)
 * 
 * @author Ngoc
 *
 */
@Service
public class BookServiceImpl {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
	
	private static final String SERVICE_BOOK = "book-service";
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * @return
	 */
	public List<Book> findAll() {
		
		ResponseEntity<Book[]> response = new RestTemplate().getForEntity(
				serviceUrl(), Book[].class);
		
		return Arrays.stream(response.getBody()).collect(Collectors.toList());
	}

	/**
	 * @param bookId
	 * @return
	 */
	public Book findBook(Long bookId) {
		return new Book(1, "Dummy Title", "Dummy Author");
	}

	private URI serviceUrl() {
		List<ServiceInstance> instances = discoveryClient.getInstances(SERVICE_BOOK);
		if (instances != null && instances.size() > 0) {
			return instances.get(0).getUri();
		}
		
		return null;
	}
}
