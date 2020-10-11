package cn.tedu.service.impl;

import cn.tedu.dao.UserDao;
import cn.tedu.dao.UserDaoImpl;
import cn.tedu.pojo.User;
import cn.tedu.service.UserService;
import cn.tedu.utils.MD5Utils;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    /**
     * 用户登录功能
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        //先对密码加密处理/加密方式md5
        String newPwd = MD5Utils.encrypt(password);
        //调用持久层 查询数据库
        return userDao.login(username,newPwd);
    }
}
