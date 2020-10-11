package cn.tedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class ExitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("downloadList");
        //清除session
        session.invalidate();

        Cookie[] c = request.getCookies();
        for (int i = 0; i < c.length; i++) {
            if (c[i].getName().equals("username") || c[i].getName().equals("password"))
                c[i].setMaxAge(0);
            response.addCookie(c[i]);
        }
        response.sendRedirect(request.getContextPath() + "/index.html");
    }
}
