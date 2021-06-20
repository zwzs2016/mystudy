package cn.tedu.cppfoto.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String mail;
    private String name;
    private char sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String fixedPhone;
    private String unit;
    private String region;
    private String address;
    private String postcode;
    private String cameraName;
    private String cameraModel;
    private String phoneNum;
    private Integer imagesId;
}
