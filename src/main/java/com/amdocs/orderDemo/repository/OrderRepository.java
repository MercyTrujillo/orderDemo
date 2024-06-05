package com.amdocs.orderDemo.repository;

import com.amdocs.orderDemo.Entities.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface OrderRepository extends CrudRepository <Order, Integer>{
}
