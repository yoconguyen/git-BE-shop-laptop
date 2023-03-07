package com.example.beshoplaptop.dto;

import lombok.Data;

@Data
public class SearchProductDto {
    private Integer index;
    private Integer pageSize;
    private Long id;
    private String nameProduct;
    private  String typeProduct;
    private  String colorProduct;
    private  Integer moneyProduct;

}
