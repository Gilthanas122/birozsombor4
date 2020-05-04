package com.greenfoxacademy.rest.repository;

import com.greenfoxacademy.rest.model.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long>{

}
