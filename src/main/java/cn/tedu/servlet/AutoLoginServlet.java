package cn.tedu.servlet;

import cn.tedu.dao.UserDao;
import cn.tedu.dao.UserDaoImpl;
import cn.tedu.pojo.User;
import cn.tedu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.awt.*;
import java.io.IOException;

public class AutoLoginServlet extends HttpServlet {
    private UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        System.err.println("AutoLoginServlet+session" + username + password);
        //判断用户是否存在

        User user = userDao.login(username, password);
        if (user == null) {
            //登录失败了
            request.setAttribute("errorMsg", "用户名或者密码错误");
            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/main.jsp").forward(request, response);
            System.out.println("登录成功");
        }
    }
}
