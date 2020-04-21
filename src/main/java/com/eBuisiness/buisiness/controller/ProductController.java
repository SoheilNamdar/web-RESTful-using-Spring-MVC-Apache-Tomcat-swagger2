package com.eBuisiness.buisiness.controller;

import com.eBuisiness.buisiness.dao.ProductDao;
import com.eBuisiness.buisiness.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "Product/{id}")
    public Product afficherUnProduit(@PathVariable int id) throws ProductNotFoundException{

       //return productDao.findById(id)
               //.orElseThrow(() -> new ProductNotFoundException(id));

        Product product = productDao.findById(id);
        if(product == null) throw
                new ProductNotFoundException("Produit " + id + " n'a pa été trouvé : " );
        return product;
    }

    @GetMapping(value = "Product")
    public List<Product> listProduit(){
        return productDao.findAll();
    }

    @GetMapping(value = "test/Product/{prixLimit}")
    public List<Product> listProduit(@PathVariable int prixLimit){
        return productDao.findByPrixGreaterThan(prixLimit);
    }


    @PostMapping(value = "/Product")
    public void ajouterUnProduit(@Valid @RequestBody Product product){
        productDao.save(product);
    }
}
