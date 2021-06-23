package ioc.car;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

public class CarConfig {
    @Bean
    //@Scope("prototype")
    //懒加载
    @Lazy
    public Car fllcar(){
        Car car=new Car();
        car.setName("法拉利");
        car.setPrice(5);
        return car;
    }
}
