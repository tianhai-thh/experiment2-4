package com.tang.service.impl;

import com.tang.dao.UserDao;
import com.tang.pojo.User;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjzhou
 * @version 1.0
 */


@Service
public class UserServiceimpl {

    @Autowired
    UserDao userDao;
    //登录方法的实现,从jsp页面获取username与password
    public boolean login(String email, String password) {
        System.out.println("验证 ->" + email);
        //调用DAO层
        User user = userDao.selectByUseremail(email);
        if (user != null) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
    //注册方法的实现,从jsp页面获取username  password
    public boolean register(User user) {
        User user1 = userDao.selectByUseremail(user.getEmail());
        if(user1 != null)return false;
        //调用DAO层
        return userDao.register(user);

    }
}
