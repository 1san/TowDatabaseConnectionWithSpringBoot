package com.san.repository1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.entity1.Laptop;
@Repository
public interface LaptopReposiroty extends JpaRepository<Laptop, Integer>{

}
