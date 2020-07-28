package com.hwl.vue.service;

import com.hwl.vue.been.User;
import com.hwl.vue.been.UserExample;
import com.hwl.vue.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> UserLogin(String username, String password){
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        return users ;
    }

    public List<User> getAllUser(String username){
        UserExample example = new UserExample();
        example.createCriteria().andUsernameLike("%"+username+"%");
        List<User> users=userMapper.selectByExample(example);
        return users;
    }
    public int CountUser(String username){
        UserExample example = new UserExample();
        example.createCriteria().andUsernameLike("%"+username+"%");
        int count = userMapper.countByExample(example);
        return count;
    }
    public int updateState(Integer id,Boolean state){
        User user = userMapper.selectByPrimaryKey(id);
        user.setState(state);
        int i = userMapper.updateByPrimaryKey(user);
        return i;
    }


    public int addUser(User user) {
        int i = userMapper.insert(user);
        return i;
    }
}
