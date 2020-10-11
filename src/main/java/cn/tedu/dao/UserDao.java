package cn.tedu.dao;

import cn.tedu.pojo.User;

public interface UserDao {
    User login(String username,String password);
}
