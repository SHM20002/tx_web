package cn.tedu.servlet;

import cn.tedu.utils.CreateVerificationCodeImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class CreateVerifyImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreateVerificationCodeImage createVCodeImage = new CreateVerificationCodeImage();
        //产生四位随机字符串
        String vCode = createVCodeImage.createCode();
        //获取session对象
        HttpSession session = request.getSession();
        session.setAttribute("cerityCode",vCode);
        //设置返回值
        response.setContentType("img/jpeg");
        //浏览器不缓存响应内容 点击一次刷新一次
        response.setHeader("Pragma","NO-cache");
        response.setHeader("Cache-Control","NO-cache");
        //设置验证码失效时间
        response.setDateHeader("Expires",0);
        //以字节流发过去，交给img的src属性去解析
        BufferedImage image = createVCodeImage.CreateImage(vCode);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image,"JPEG",out);
        out.flush();
        out.close();
    }
}
