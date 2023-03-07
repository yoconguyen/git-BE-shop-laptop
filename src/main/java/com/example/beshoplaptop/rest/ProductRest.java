package com.example.beshoplaptop.rest;

import com.example.beshoplaptop.dto.ProductDto;
import com.example.beshoplaptop.dto.SearchProductDto;
import com.example.beshoplaptop.entities.ProductLap;
import com.example.beshoplaptop.reponsitory.ProductRepository;
import com.example.beshoplaptop.reponsitory.custom.ProductRepositoryCustom;
import com.example.beshoplaptop.repose.ProductRepose;
import com.example.beshoplaptop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRest {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepositoryCustom productRepositoryCustom;

    @PostMapping("/create")
    public ProductLap addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    };
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductLap> deleteProduct(@PathVariable Long id) {
        return  productService.deleteProduct(id);
    };
    @PutMapping("/update")
    public ProductLap updateProduct(@RequestBody ProductDto productDto){
        return  productService.updateProduct(productDto);
    };
    @PostMapping("/page")
    public List<ProductLap> pageProduct (@RequestBody ProductDto productDto){
        return  productService.pageProduct();
    };

    @PostMapping("/search")
    public List<ProductRepose> SearchProduct (@RequestBody SearchProductDto searchProductDto){
        return  productRepositoryCustom.Search(searchProductDto);
    };
}
