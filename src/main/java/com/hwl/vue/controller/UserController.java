package com.hwl.vue.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwl.vue.been.User;
import com.hwl.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RestController
public class UserController {
   @Autowired
    private UserService userService;

   @RequestMapping("/allUser")
    public String getAllUser(String username,
                             @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                             @RequestParam(value = "pageSize") Integer pageSize){
       PageHelper.startPage(pageNum,pageSize);
       List<User> users=userService.getAllUser(username);
       int numbers = userService.CountUser(username);
       PageInfo<User> pageInfo = new PageInfo<User>(users);
       HashMap<String, Object> res = new HashMap<>();
       res.put("pageInfo",pageInfo);
       res.put("numbers",numbers);
       String s = JSON.toJSONString(res);
       return s;
   }
   @RequestMapping("/userState")
   public String updateUserState(@RequestParam("id")Integer id,
                                 @RequestParam("state")Boolean state){
      int i = userService.updateState(id, state);
      String s=i > 0 ? "success" : "error";
      return s;
   }

   @RequestMapping("/addUser")
   public String addUser(@RequestBody User user){
      user.setRole("普通用户");
      user.setState(false);
      int i=userService.addUser(user);
      return i>0 ? "success":"error";
   }
}
