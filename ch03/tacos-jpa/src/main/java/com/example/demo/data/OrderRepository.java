package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojo.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
