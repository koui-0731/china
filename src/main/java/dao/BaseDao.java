package dao;

import java.sql.*;

/**
 * 工具类
 */
public class BaseDao {
    public  String DRIVER="com.mysql.jdbc.Driver"; // 数据库驱动

    public String URL="jdbc:mysql://localhost:3306/maven_user?useUnicode=true&characterEncoding=utf-8";

    public  String DBNAME = "root"; // 数据库用户名

    public  String DBPASS = null; // 数据库密码

    /** 连接对象 */
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * 得到数据库连接
     * @throws ClassNotFoundException
     * @throws SQLException
     * @return 数据库连接
     */
    public Connection getConnection() {

        try {
/*            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/news");
            con = ds.getConnection();*/
            Class.forName(DRIVER); // 注册驱动
            con = DriverManager.getConnection(URL,DBNAME,DBPASS); // 获得数据库连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con; // 返回连接
    }

    /**
     * 查询操作
     *
     * @param sql
     * @param params
     * @return
     */
    public ResultSet excuteQuery(String sql, Object[] params) {
        con = getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    /**
     * 增删改方法
     * @param sql
     * @param params
     * @return
     */
    public int insert(String sql, Object[] params){
        getConnection();
        int count=0;
        try {
            pstmt=con.prepareStatement(sql);
            if(params!=null){
                for (int i=0;i<params.length;i++){
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 释放资源
     */
    public void colseAll(){
        try {
            if(rs!=null){
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(con!=null){
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}