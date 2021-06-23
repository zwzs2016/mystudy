package ioc.zhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZhangFei {
    private String name="张翼德";

    @Autowired
    private SnakeLancer snakeLancer;

    @Autowired
    private YellowFly yellowFly;

    public void fight(){
        System.out.println(name+"坐上"+yellowFly+"使用"+snakeLancer);
    }
}
