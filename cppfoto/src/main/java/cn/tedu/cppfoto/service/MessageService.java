package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.entity.Message;
import cn.tedu.cppfoto.entity.User;

import java.util.List;

public interface MessageService {

    List<Message> select(int id);

    void deleteById(int id);

}
