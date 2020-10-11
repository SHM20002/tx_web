package cn.tedu.dao;

import cn.tedu.pojo.User;
import cn.tedu.service.impl.UserServiceImpl;
import cn.tedu.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class MyTest {

    @Test
    public void getComm(){
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
    }

    @Test
    public void run(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "123");
        System.out.println(admin);
    }
}
