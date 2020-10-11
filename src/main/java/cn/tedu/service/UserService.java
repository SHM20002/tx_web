package cn.tedu.service;

import cn.tedu.pojo.User;

public interface UserService {

    User login(String username,String password);
}
