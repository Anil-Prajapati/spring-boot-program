package com.nareshit.advjpa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@Entity
@Table(name="tbl_book")


@NamedQueries(value= {


		//Implementation Layer
		//NamedQuery1
		@NamedQuery(name="Book.fetchBookByName",
				query ="SELECT  DISTINCT b from Book b  Join b.publishers   p where b.bookName=?1 ")



		//NamedQuery2
})

public class Book {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer bookId;


	@Column(name = "book_name")
	private String bookName;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "book_publisher",
    joinColumns = @JoinColumn(name="bookId",referencedColumnName = "book_id"),
    inverseJoinColumns = @JoinColumn(name="publisherId",referencedColumnName = "publisher_id")
    )
    private Set<Publisher> publishers;




	public Integer getBookId() {
		return bookId;
	}


	public void setId(Integer id) {
		this.bookId = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public Set<Publisher> getPublishers() {
		return publishers;
	}


	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}


	public Book(String bookName, Set<Publisher> publishers) {
		super();
		this.bookName = bookName;
		this.publishers = publishers;
	}

	public Book() {}

	@Override
	public String toString() {

		String result = String.format("Book Data  [id=%d,name='%s']%n", bookId, bookName);
		// Book Data[id=1,name='Book A']

		if (publishers != null)
			for (Publisher publisher : publishers) {

				result += String.format("Publisher [id=%d,name='%s']%n", publisher.getPublisherId(),
						publisher.getPublisherName());
			}

		return result;

	}


}
