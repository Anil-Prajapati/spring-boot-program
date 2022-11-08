package com.derivedmethod.implementation.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="publisher")
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	
	@Column(name="publisher_name")
	private String publisherName;
	
	@ManyToMany(mappedBy = "publishers")
	private Set<Book> books;
	
	public Publisher(String publisherName) {
		this.publisherName=publisherName;
	}
	

	public Publisher() {}
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPublisherName() {
		return publisherName;
	}


	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}


	public Set<Book> getBooks() {
		return books;
	}


	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		String result = String.format
				("Publisher [id=%d, name='%s']%n", id, publisherName);
		if (books != null) {
			for (Book book : books) {
				result += String.format("Book[id=%d, name='%s']%n", book.getId(),
						book.getBookName());
			}
		}

		return result;
	}
	
	
	

	
	
}
