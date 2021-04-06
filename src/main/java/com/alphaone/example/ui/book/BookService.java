package com.alphaone.example.ui.book;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BookService.class);
	
	/**
	 * @return
	 */
	public List<Book> findAll() {
		return Arrays.asList(new Book(1, "Dummy Title", "Dummy Author"));
	}

	/**
	 * @param bookId
	 * @return
	 */
	public Book findBook(Long bookId) {
		return new Book(1, "Dummy Title", "Dummy Author");
	}

}
