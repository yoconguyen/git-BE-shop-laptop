package com.example.beshoplaptop.service;

import com.example.beshoplaptop.dto.ProductDto;
import com.example.beshoplaptop.entities.ProductLap;
import com.example.beshoplaptop.reponsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {

    @Autowired
    private ProductRepository productReponsitory;
// add product
    public ProductLap addProduct(ProductDto productDto){
        ProductLap productLap = new ProductLap();
        productLap.setNameProduct(productDto.getNameProduct());
        productLap.setColosProduct(productDto.getColorProduct());
        productLap.setMoneyProduct(productDto.getMoneyProduct());
        productLap.setTypeProduct(productDto.getTypeProduct());
        productReponsitory.save(productLap);
        return productLap;
    };
// delete product
    public  ResponseEntity deleteProduct(Long id){
        ProductLap productLap = productReponsitory.findById(id).get();
        productReponsitory.deleteById(id);
        return ResponseEntity.ok(productLap);

    };
    // update product
    public ProductLap updateProduct(ProductDto productDto){
        Optional<ProductLap> optionalProduct = productReponsitory.findById(productDto.getId());
        optionalProduct.get().setNameProduct(productDto.getNameProduct());
        optionalProduct.get().setMoneyProduct(productDto.getMoneyProduct());
        optionalProduct.get().setTypeProduct(productDto.getTypeProduct());
        optionalProduct.get().setColosProduct(productDto.getColorProduct());
        productReponsitory.save(optionalProduct.get());
        return  optionalProduct.get();
    };

    //page product
    public List<ProductLap> pageProduct(){
        Pageable pageable = (Pageable) PageRequest.of(0 , 10);

        return productReponsitory.findAll(pageable).getContent();
    };

}
