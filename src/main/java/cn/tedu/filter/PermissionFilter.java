package cn.tedu.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PermissionFilter implements Filter {

    private String notCheckUri;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 将ServletRequest 类型参数转换为 HttpServletRequest类型
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getServletPath();  // 获取请求的 URL-Pattern地址

        // 请求地址不在需要过滤的列表范围内，需要判断是否已经登录
        if (notCheckUri.indexOf(path) == -1) {
            HttpSession session = request.getSession();
            if (session.getAttribute("user") == null) { //没有登录
                if (path.equals("/main.jsp")) { // 检查 cookie 是否有值
                    Cookie cookies[] = request.getCookies();
                    String userName = null;
                    String userPassword = null;
                    for (int i=0;i<cookies.length;i++) {
                        if(cookies[i].getName().equals("username")) userName = cookies[i].getValue();
                        if(cookies[i].getName().equals("password")) userPassword = cookies[i].getValue();
                    }
                    if(userName==null||userPassword==null) {
                        request.setAttribute("errorMsg","抱歉，您尚未登录!!");
                        request.getRequestDispatcher("/page/error.jsp").forward(request,resp);
                    } else {
                        session.setAttribute("username",userName);
                        session.setAttribute("password",userPassword);
                        request.getRequestDispatcher("/AutoLogin.do").forward(request,resp);
                    }
                } else {
                    request.setAttribute("errorMsg","抱歉，您尚未登录!!");
                    request.getRequestDispatcher("/page/error.jsp").forward(request,resp);
                }
            } else {
                chain.doFilter(req,resp);
            }
        } else  {
            chain.doFilter(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        notCheckUri = config.getInitParameter("notCheckUri");
    }

}
