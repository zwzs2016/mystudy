package ioc;

import org.springframework.context.annotation.Bean;

public class Config {
    @Bean
    public Hero hero(){
        Hero h=new Hero();
        h.setName("猪八戒");
        h.setAge(500);
        return h;
    }
}
