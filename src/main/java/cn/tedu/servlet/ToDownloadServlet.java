package cn.tedu.servlet;



import cn.tedu.dao.DownloadDao;
import cn.tedu.dao.DownloadDaoImpl;
import cn.tedu.pojo.Download;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToDownloadServlet extends HttpServlet {

    private DownloadDao downloadDao = new DownloadDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Download> download = downloadDao.getDownload();
        request.setAttribute("downloadList", download);
        request.getSession().setAttribute("downloadList", download);
        request.getRequestDispatcher("/main/download.jsp").forward(request, response);
    }
}
