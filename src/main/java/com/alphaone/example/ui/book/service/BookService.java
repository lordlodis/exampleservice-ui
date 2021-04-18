package com.alphaone.example.ui.book.service;

import java.util.List;

import com.alphaone.example.ui.book.model.Book;

/**
 * Interface to access Books
 * @author Ngoc
 *
 */
public interface BookService {

	/**
	 * @return All books
	 */
	List<Book> findAll();

	/**
	 * @param bookId
	 * @return
	 */
	Book findBook(Long bookId);

}