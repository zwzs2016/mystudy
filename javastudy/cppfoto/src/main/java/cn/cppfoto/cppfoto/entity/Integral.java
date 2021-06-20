package cn.cppfoto.cppfoto.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Integral {
    private Integer id;
    private String content;
    private Date createDate;
    private String pay;
    private String explain;
    private Integer usrId;
}
