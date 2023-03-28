package com.pfcti.springdata.reactive.repository;

import com.pfcti.springdata.reactive.model.Employee;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer>{
    @Query("{'name':  ?0}")
    Flux<Employee> findByName(final String name);
}

