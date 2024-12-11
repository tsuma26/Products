package com.ProductService.Products.services;

import com.ProductService.Products.dtos.ProductResponse;
import com.ProductService.Products.models.Category;
import com.ProductService.Products.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakestoreProductStore implements IProductService{

    private final RestTemplate restTemplate;
    FakestoreProductStore(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProduct(Long id) {
        ProductResponse productResponse = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductResponse.class);
        return productResponseMapper(productResponse);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponse[] productResponse = restTemplate.getForObject("https://fakestoreapi.com/products/", ProductResponse[].class);
        List<Product> products = new ArrayList<>();
        for(ProductResponse response: productResponse) {
            products.add(productResponseMapper(response));
        }
        return products;
    }

    private Product productResponseMapper(ProductResponse response) {
        Product product = new Product();
        product.setId(response.getId());
        product.setName(response.getTitle());
        product.setDescription(response.getDescription());
        product.setPrice(response.getPrice());
        product.setImage(response.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(response.getCategory());
        return product;
    }
}
