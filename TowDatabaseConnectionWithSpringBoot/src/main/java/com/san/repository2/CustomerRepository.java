package com.san.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.entity2.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
