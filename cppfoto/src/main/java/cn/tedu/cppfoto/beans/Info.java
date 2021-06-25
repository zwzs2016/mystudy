package cn.tedu.cppfoto.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Info {
    private Integer categoryId;
    private String searchText;
    private String searchUser;
}
