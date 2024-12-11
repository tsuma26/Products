package com.ProductService.Products.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;
}
