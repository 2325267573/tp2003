package cn.kgc.demo.demo.service;

import cn.kgc.demo.demo.entity.User;

import java.util.List;

public interface UserService {
    public  boolean verify (String userName,String userPassword);

    public  void register (User user);

    public List<User> searchAll();
}
