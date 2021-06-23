package ioc.san;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class SanConfig {
    @Bean
    public DragonBlade blade1(){
        return new DragonBlade();
    }
    @Bean
    public DragonBlade blade2(){
        return new DragonBlade();
    }
    @Bean
    public GuanYu guanYu(DragonBlade blade1){
        GuanYu guanYu = new GuanYu();
        guanYu.setBlade(blade1);
        return guanYu;
    }
}
