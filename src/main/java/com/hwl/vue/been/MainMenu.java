package com.hwl.vue.been;

import lombok.Data;
//主导航
import java.util.List;

@Data
public class MainMenu {
    private int id;
    private String title;
    private String path;
    private List<SubMenu> sList;
}
