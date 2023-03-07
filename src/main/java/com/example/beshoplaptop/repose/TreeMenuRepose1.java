package com.example.beshoplaptop.repose;

import com.example.beshoplaptop.entities.TreeMenu;
import lombok.Data;

import java.util.List;
@Data
public class TreeMenuRepose1 {
    private Long id;
    private Long pid;
    private String nameFolder;
    private  String file;
    private List<TreeMenu> listChirld;
}
