package com.example.beshoplaptop.entities;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "MenuTree")
public class TreeMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "parent_id")
    private Long pid;

    @Column(name = "name_folder")
    private String nameFolder;
    @Column(name = "file")
    private  String file;


}
