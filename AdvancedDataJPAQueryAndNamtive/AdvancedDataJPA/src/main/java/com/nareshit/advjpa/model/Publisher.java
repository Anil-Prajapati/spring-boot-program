package com.nareshit.advjpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisher_id")
	private Integer publisherId;



	@Column(name = "publisher_name")
	private String publisherName;

	@ManyToMany(mappedBy = "publishers")
	private Set<Book> books;


	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public Publisher(Integer publisherId) {
		super();
		this.publisherId = publisherId;
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

	public Publisher(String publisherName, Set<Book> books) {
		super();
		this.publisherName = publisherName;
		this.books = books;
	}

	public Publisher() {}
	public Publisher(String publisherName) {
		super();
		this.publisherName = publisherName;

	}

	@Override
	public String toString() {
		String result = String.format("Publisher [id=%d, name='%s']%n", publisherId, publisherName);
		if (books != null) {
			for (Book book : books) {
				result += String.format("Book[id=%d, name='%s']%n", book.getBookId(), book.getBookName());
			}
		}

		return result;
	}
}
