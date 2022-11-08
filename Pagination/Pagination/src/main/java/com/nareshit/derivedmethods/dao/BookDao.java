package com.nareshit.derivedmethods.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethods.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer>{

	public Iterable<Book> fetchBookByName(String bookName);

}
