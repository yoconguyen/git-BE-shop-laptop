package com.example.beshoplaptop.reponsitory;

import com.example.beshoplaptop.entities.TreeMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeMenuRepository extends JpaRepository<TreeMenu, Long> {
}
