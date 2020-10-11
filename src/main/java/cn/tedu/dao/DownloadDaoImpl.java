package cn.tedu.dao;


import cn.tedu.pojo.Download;
import cn.tedu.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DownloadDaoImpl implements DownloadDao {

    public List<Download> getDownload() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        List<Download> list = new ArrayList<Download>();
        try {
            String sql = "select * from tx_web.t_downloadlist";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
			resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Download download = new Download();
                download.setId(resultSet.getInt(1));
                download.setName(resultSet.getString(2));
                download.setPath(resultSet.getString(3));
                download.setDescription(resultSet.getString(4));
                download.setSize(resultSet.getLong(5));
                download.setStar(resultSet.getInt(6));
                download.setImage(resultSet.getString(7));
                list.add(download);
            }
        } catch (SQLException e) {
            System.err.println("查询下载列表失败！");
            e.printStackTrace();
        }finally {
			JdbcUtils.close(conn,ps,resultSet);
		}
        return list;
    }

}
