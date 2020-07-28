package com.hwl.vue.controller;

import com.alibaba.fastjson.JSON;
import com.hwl.vue.been.User;
import com.hwl.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        String flag="error";
        List<User> users = userService.UserLogin(user.getUsername(), user.getPassword());
        HashMap<String,Object> res=new HashMap<>();
        if (users.size()!=0){
            flag="ok";
        }
        res.put("flag",flag);
        res.put("user",users);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }


}
