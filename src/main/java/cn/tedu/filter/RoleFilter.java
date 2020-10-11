package cn.tedu.filter;


import cn.tedu.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RoleFilter implements Filter {
    private String roleCheckUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        roleCheckUrl = filterConfig.getInitParameter("roleCheckUrl");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        String path = request1.getServletPath();

        if (roleCheckUrl.indexOf(path) != -1) {
            HttpSession session = request1.getSession();
            User user = (User) session.getAttribute("user");
            if (user.getRole().equals("1")) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("error", "抱歉，当前用户没有访问该资源的权限!!");
                request.setAttribute("role", "true");
                request.getRequestDispatcher("/error.jsp").forward(request1, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
