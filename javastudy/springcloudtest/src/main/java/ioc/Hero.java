package ioc;

import lombok.Data;

@Data
public class Hero {
    private String name;
    private Integer age;

    public Hero(){
        System.out.println("被实例化了");
    }
}
