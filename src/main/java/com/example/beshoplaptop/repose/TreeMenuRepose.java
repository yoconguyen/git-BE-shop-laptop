package com.example.beshoplaptop.repose;

import com.example.beshoplaptop.entities.TreeMenu;
import lombok.Data;

import java.util.List;

@Data
public class TreeMenuRepose {
    private Long id;
    private Long pid;
    private String nameFolder;
    private  String file;
    private List<TreeMenuRepose1> listChirld;

//    public TreeMenuRepose(Long pid, String nameFolder, String file) {
//        this.pid = pid;
//        this.nameFolder = nameFolder;
//        this.file = file;
//    }
}
