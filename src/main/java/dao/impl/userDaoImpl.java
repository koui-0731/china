package dao.impl;

import dao.BaseDao;
import dao.userDao;
import entiy.Maven_user;

import java.sql.ResultSet;

public class userDaoImpl extends BaseDao implements userDao {
    /**
     * 登录
     * @return
     */
    public int getselect(String name,String pwd) {
        String sql="select count(*) from user where name=? and pwd=?";
        Object [] params={name,pwd};
        ResultSet rs=null;
        Maven_user mu=new Maven_user();
        int count=0;
        try {
            rs=super.excuteQuery(sql,params);
            rs.next();
            count=rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
