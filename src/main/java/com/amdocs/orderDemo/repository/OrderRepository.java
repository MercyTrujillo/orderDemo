package com.amdocs.orderDemo.repository;

import com.amdocs.orderDemo.Entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository <Order, Integer>{
}
