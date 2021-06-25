package ioc.ouhe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GuanYu {
    private String name="关羽";

    @Autowired
    @Qualifier("dragonBlade")
    private Weapon weapon;

    public void fight(){
        System.out.println(name+"使用"+weapon.getName());
    }
}
