package com.alphaone.example.ui.book.service.rest;

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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alphaone.example.ui.book.model.Book;
import com.alphaone.example.ui.book.service.BookService;

/**
 * Service APIs that communicate with Book microservice REST API to access data.
 * 
 * Service can communicate with each other via direct URL (testing) or using discovery service (EurekaServer)
 * 
 * @author Ngoc
 *
 */
@Component(value = "REST")
public class BookServiceImpl implements BookService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
	
	private static final String SERVICE_BOOK_APPNAME = "book-service";
	
	private static final String SERVICE_BOOK_GETALL = "/api/books";
	
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * @return All books
	 */
	@Override
	public List<Book> findAll() {
		
		URI serviceUrl = serviceUrl();
		
		LOGGER.info("Retrieved service URI to book service: " + serviceUrl);
		
		ResponseEntity<Book[]> response = new RestTemplate().getForEntity(
				serviceUrl.toString() + SERVICE_BOOK_GETALL, Book[].class);
		
		return Arrays.stream(response.getBody()).collect(Collectors.toList());
	}

	/**
	 * @param bookId
	 * @return
	 */
	@Override
	public Book findBook(Long bookId) {
		return new Book(1, "Dummy Title", "Dummy Author");
	}

	/**
	 * @return URL to book service
	 */
	private URI serviceUrl() {
		List<ServiceInstance> instances = discoveryClient.getInstances(SERVICE_BOOK_APPNAME);
		if (instances != null && instances.size() > 0) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Found " + instances.size() + " instances of service " + SERVICE_BOOK_APPNAME);
				for (ServiceInstance serviceInstance : instances) {
					LOGGER.debug("Intance: " + serviceInstance.toString());
				}
			}
			
			URI uri = instances.get(0).getUri();
			return uri;
		}
		
		return null;
	}
}
