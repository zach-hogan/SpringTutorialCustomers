package com.ZHogan.Tutorial.repository;

import com.ZHogan.Tutorial.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByName(String nameToFind);
}
