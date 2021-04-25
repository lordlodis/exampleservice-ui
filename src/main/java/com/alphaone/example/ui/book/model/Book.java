package com.alphaone.example.ui.book.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

	private long id;

	private String title;

	private String author;

	private BookRating avgRating;

	protected Book() {
	}

	public Book(long id, String title, String author, BookRating avgRating) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.avgRating = avgRating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookRating getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(BookRating avgRating) {
		this.avgRating = avgRating;
	}
	
	public double getRating() {
		if (avgRating == null) {
			return 0;
		} else {
			return avgRating.getAvgRating();
		}
	}
}
