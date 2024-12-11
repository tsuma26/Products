package com.ProductService.Products.services;

import com.ProductService.Products.models.Product;

import java.util.List;

public interface IProductService {

    Product getProduct(Long id);
    List<Product> getAllProducts();
}
