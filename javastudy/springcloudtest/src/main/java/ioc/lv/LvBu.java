package ioc.lv;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class LvBu {
    private String name="吕奉先";

    @Autowired
    private RedRabbit redRabbit;

    @Autowired
    private SkyLance skyLance;

    public void fight(){
        System.out.println(name+"使用"+skyLance+"战斗");
    }
    public void fight1(){
        System.out.println(name+"骑着"+redRabbit+"输出");
    }
}
