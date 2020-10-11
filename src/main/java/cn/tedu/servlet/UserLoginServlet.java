package cn.tedu.servlet;

import cn.tedu.pojo.User;
import cn.tedu.service.UserService;
import cn.tedu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先接收到请求参数（解决中文乱码问题）
        //获取到用户输入的用户名和密码
        String username = request.getParameter("userName");
        String password = request.getParameter("passWord");
        String vCode = request.getParameter("vCode");
        String[] radio_checks = request.getParameterValues("radio_check");
        User user = userService.login(username, password);
        System.out.println(user);
        //获取session中的验证码
        String cerityCode = (String) request.getSession().getAttribute("cerityCode");
        //与用户输入的验证码判断
        if (!vCode.equalsIgnoreCase(cerityCode)) {
            //如果验证码不匹配
            //登录失败了
            request.setAttribute("errorMsg", "验证码错误！");
            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
            return;
        }

        if (user == null) {
            //登录失败了
            request.setAttribute("errorMsg", "用户名或者密码错误");
            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
        } else {
            if (radio_checks != null){
                Cookie name_cookie = new Cookie("username",username);
                Cookie pwd_cookie = new Cookie("password",password);
                name_cookie.setMaxAge(60*60*24*7);
                pwd_cookie.setMaxAge(60*60*24*7);
                response.addCookie(name_cookie);
                response.addCookie(pwd_cookie);
            }
            //登录成功 把user对象存储起来，存储在Session中
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/main.jsp").forward(request, response);
            System.out.println("登录成功");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
