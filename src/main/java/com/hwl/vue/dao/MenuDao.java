package com.hwl.vue.dao;

import com.hwl.vue.been.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMunes();
}
