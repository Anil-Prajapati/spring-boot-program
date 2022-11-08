package com.nareshit.advjpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.advjpa.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer>{

	public Book findByBookName(String bookName);

	public Iterable<Book> fetchBookByName(String bookName);

}
