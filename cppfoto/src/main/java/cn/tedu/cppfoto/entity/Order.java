package cn.tedu.cppfoto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Order {
    private Integer id;
    private Integer paystatus;
    private Integer isCollection;
    private Integer wordsId;
    private Integer userId;
    private Integer videoId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDate;
}
