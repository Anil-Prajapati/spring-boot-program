package com.derivedmethod.implementation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derivedmethod.implementation.model.Publisher;

@Repository
public interface PublisherDao extends CrudRepository<Publisher, Integer>{

}
