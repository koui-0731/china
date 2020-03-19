package dao;

import entiy.Maven_user;

/**
 * 数据访问层定义接口
 */
public interface userDao {
    /**
     * 实现登录的方法
     */
    int getselect(String name,String pwd);
}
