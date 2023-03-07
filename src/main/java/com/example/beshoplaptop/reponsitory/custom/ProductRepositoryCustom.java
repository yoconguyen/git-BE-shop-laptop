package com.example.beshoplaptop.reponsitory.custom;

import com.example.beshoplaptop.dto.SearchProductDto;
import com.example.beshoplaptop.repose.ProductRepose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryCustom {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public List<ProductRepose> Search(SearchProductDto searchProductDto){
        Map<String, Object> param = new HashMap<>();
//        param.put("name", searchProductDto.getNameProduct());
        StringBuilder stringBuilder = new StringBuilder();
//
//        String sql = "SELECT * FROM product " +
//                "WHERE name_product = :name  ";
//
//        param.put("type",searchProductDto.getTypeProduct());
//        if(param.get("type")!=null)
//            sql+="and type_product = :type";
//
//        param.put("type",searchProductDto.getTypeProduct());
//        if(param.get("type")!=null)
//            sql+="and type_product = :type";

        stringBuilder.append("SELECT * FROM product WHERE 1=1 ");

        if(searchProductDto.getId()!= null){
            stringBuilder.append("AND id = :id ");

        }
        if(searchProductDto.getNameProduct()!= null){
            stringBuilder.append("AND name_product = :name ");

        }
        if(searchProductDto.getTypeProduct()!= null){
            stringBuilder.append("AND type_product = :type ");

        }
        if(searchProductDto.getColorProduct()!= null){
            stringBuilder.append("AND color_product = :color ");

        }
        if(searchProductDto.getTypeProduct()!= null){
            stringBuilder.append("AND money_product = :money ");

        }
        stringBuilder.append("ORDER BY id ASC LIMIT :index,:pagesize");
        param.put("index",searchProductDto.getIndex()* searchProductDto.getPageSize());
        param.put("pagesize",searchProductDto.getPageSize());
        param.put("id",searchProductDto.getId());
        param.put("name",searchProductDto.getNameProduct());
        param.put("type",searchProductDto.getTypeProduct());
        param.put("color",searchProductDto.getColorProduct());
        param.put("money",searchProductDto.getMoneyProduct());




        List<ProductRepose> productReposes = jdbcTemplate.query(stringBuilder.toString(), param, new BeanPropertyRowMapper<>(ProductRepose.class));


        return  productReposes;
    };
}
