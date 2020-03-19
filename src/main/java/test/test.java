package test;

import service.impl.userServiceImpl;
import service.userService;

public class test {
    public static void main(String[] args) {
        userService us= new userServiceImpl();
        int count=  us.getselect("admin","123456");
        System.out.println(count);
    }
}
