package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.entity.User;


public interface UserService {
    void integral(User user);

    void register(User user);

    void setUser(User user);

    User getUser(User user);

    void update(User user);

    User check(User user);

    void insert(User user);

    User selectById(int id);

}
