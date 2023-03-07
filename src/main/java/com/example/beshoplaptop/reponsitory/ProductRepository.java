package com.example.beshoplaptop.reponsitory;


import com.example.beshoplaptop.entities.ProductLap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<ProductLap,Long> {


}
