package com.ProductService.Products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel{
    private String description;
    private String image;
    private float price;

    @ManyToOne
    private Category category;
}
