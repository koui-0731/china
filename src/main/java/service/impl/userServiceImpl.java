package service.impl;

import dao.impl.userDaoImpl;
import dao.userDao;
import entiy.Maven_user;
import service.userService;

public class userServiceImpl implements userService {
    /**
     * 登录
     * @return
     */
    userDao user=new userDaoImpl();
    public int getselect(String name, String pwd) {
        int count=user.getselect(name, pwd);
        return count;
    }
}
