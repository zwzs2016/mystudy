package cn.cppfoto.cppfoto.entity;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String mail;
    private String name;
    private char sex;
    private Date birthday;
    private Integer fixedPhone;
    private String unit;
    private String region;
    private String address;
    private String postcode;
    private Integer cameraId;
    private String cameraModel;
    private Integer phoneNum;
}
