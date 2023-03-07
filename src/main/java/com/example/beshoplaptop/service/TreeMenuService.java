package com.example.beshoplaptop.service;

import com.example.beshoplaptop.entities.TreeMenu;
import com.example.beshoplaptop.reponsitory.TreeMenuRepository;
import com.example.beshoplaptop.repose.TreeMenuRepose;
import com.example.beshoplaptop.repose.TreeMenuRepose1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeMenuService {
    @Autowired
    TreeMenuRepository treeMenuRepository;

    public List<TreeMenuRepose> getList() {
        List<TreeMenuRepose> list = new ArrayList<>();
        List<TreeMenu> db = treeMenuRepository.findAll();
//        System.out.println(db instanceof List<TreeMenuRepose>);
        for(TreeMenu repose: db){
            if(repose.getPid() == null){
                TreeMenuRepose treeMenuRepose = new TreeMenuRepose();
                treeMenuRepose.setId(repose.getId());
                treeMenuRepose.setPid(repose.getPid());
                treeMenuRepose.setNameFolder(repose.getNameFolder());
                treeMenuRepose.setFile(repose.getFile());
                List<TreeMenuRepose1> treeMenuListChirlden = new ArrayList<>();

                for(TreeMenu treeMenu: db){
                    if(treeMenu.getPid()!=null && (treeMenu.getPid() == repose.getId())) {
                        {
                            TreeMenuRepose1 treeMenuRepose1 = new TreeMenuRepose1();
                            treeMenuRepose1.setId(treeMenu.getId());
                            treeMenuRepose1.setPid(treeMenu.getPid());
                            treeMenuRepose1.setNameFolder(treeMenu.getNameFolder());
                            treeMenuRepose1.setFile(treeMenu.getFile());
                            List<TreeMenu> treeMenuListChirlden1 = new ArrayList<>();

                            for(TreeMenu treeMenu1:db){
                                if(treeMenu1.getPid()!=null && treeMenu1.getPid() == treeMenu.getId()){
                                    treeMenuListChirlden1.add(treeMenu1);
                                }
                            }
                            treeMenuRepose1.setListChirld(treeMenuListChirlden1);
                            treeMenuListChirlden.add(treeMenuRepose1);
                        }
                    }
                }
                treeMenuRepose.setListChirld(treeMenuListChirlden);
         list.add(treeMenuRepose);
            }
        }
     return  list;
    }
}
