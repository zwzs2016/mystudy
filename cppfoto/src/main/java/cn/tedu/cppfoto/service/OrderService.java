package cn.tedu.cppfoto.service;

public interface OrderService {
    void order(int videoId,int userId,String type);

    void deleteById(int id);

    void updateCollectionById(int id,int isCollection);
}
