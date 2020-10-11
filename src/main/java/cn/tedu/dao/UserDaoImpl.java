package cn.tedu.dao;

import cn.tedu.pojo.User;
import cn.tedu.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        User user = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from tx_web.t_user where username=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            //执行查询
            rs = ps.executeQuery();
            //从结果集中获取查询到的数据，封装到User对象中，返回
            if (rs.next()) {
                user = new User()
                        .setUsername(rs.getString("username"))
                        .setPassword(rs.getString("password"))
                        .setChrName(rs.getString("chrName"))
                        .setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return user;
    }

}
