package com.nareshit.derivedmethods.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethods.model.Publisher;

@Repository
public interface PublisherDao extends CrudRepository<Publisher, Integer>{

}
