package ioc.san;

import lombok.Data;

@Data
public class GuanYu {

    private String name="关羽";

    private DragonBlade blade;

    public void fight(){
        System.out.println(name+"使用"+blade+"战斗");
    }
}
