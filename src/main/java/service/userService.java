package service;

import entiy.Maven_user;

/**
 * 业务逻辑层定义接口
 */
public interface userService {
    /**
     * 实现登录的方法
     */
    int getselect(String name, String pwd);
}
