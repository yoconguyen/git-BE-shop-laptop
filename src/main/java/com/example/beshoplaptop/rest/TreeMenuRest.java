package com.example.beshoplaptop.rest;

import com.example.beshoplaptop.entities.TreeMenu;
import com.example.beshoplaptop.service.TreeMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nodes")
public class TreeMenuRest {
 @Autowired
    TreeMenuService treeMenuService;

 @GetMapping()
    public  List<?> getMenuTree(){

     return treeMenuService.getList();
 }
}
