package ioc.ouhe;

import org.springframework.stereotype.Component;

@Component
public class DragonBlade implements Weapon {

    @Override
    public String getName() {
        return "青龙刀";
    }
}
