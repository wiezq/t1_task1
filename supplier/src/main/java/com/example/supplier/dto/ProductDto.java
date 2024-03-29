package com.example.supplier.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private Long price;
    private Long categoryId;
    private Float averageRating;
    private String name;
    private String description;
}
