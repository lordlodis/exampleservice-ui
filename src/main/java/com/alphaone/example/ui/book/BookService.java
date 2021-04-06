package com.alphaone.example.ui.book;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service APIs that communicate with Book microservice REST API to access data.
 * 
 * Service can communicate with each other via direct URL (testing) or using discovery service (EurekaServer)
 * 
 * @author Ngoc
 *
 */
@Service
public class BookService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BookService.class);
	
	/**
	 * @return
	 */
	public List<Book> findAll() {
		// FIXME: This does not work. Need to look into it and EUREKA (Spring cloud)
		ResponseEntity<Book[]> response = new RestTemplate().getForEntity(
				"http://localhost:9090/api/books", Book[].class);
		
		return Arrays.stream(response.getBody()).collect(Collectors.toList());
	}

	/**
	 * @param bookId
	 * @return
	 */
	public Book findBook(Long bookId) {
		return new Book(1, "Dummy Title", "Dummy Author");
	}

}
