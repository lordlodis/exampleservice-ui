package com.alphaone.example.ui.book.serviceclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alphaone.example.ui.book.model.Book;

/**
 * Interface to access Books
 * @author Ngoc
 *
 */
@FeignClient(value = "book-service")
public interface BookServiceClient {

	/**
	 * @return All books
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/api/books")
	List<Book> findAll();

	/**
	 * @param bookId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/api/books/{bookId}", consumes = "application/json")
	Book findBook(@PathVariable("bookId") Long bookId);

}