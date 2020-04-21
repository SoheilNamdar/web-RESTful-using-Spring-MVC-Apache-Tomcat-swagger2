package com.eBuisiness.buisiness.dao;

import com.eBuisiness.buisiness.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//manipulates the data in the database
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findById(int id);

    List<Product> findByPrixGreaterThan(int prixLimit);
}
