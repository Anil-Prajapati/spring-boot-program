package com.derivedmethod.implementation.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derivedmethod.implementation.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer>{
	
	//Abstract Method for a named query method which will retieve a particular book from book table.
	public List<Book> findAllBookBybookId(int bookId);

}
