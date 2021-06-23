package ioc.car;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCar {
    AnnotationConfigApplicationContext ac;
    @Before
    public void before(){
        ac=new AnnotationConfigApplicationContext(CarConfig.class);

    }
    @After
    public void after(){
        ac.close();
    }

    @Test
    public void test(){
       Car car=  ac.getBean("fllcar",Car.class);
       Car car1=  ac.getBean("fllcar",Car.class);
       car.setName("大众");
       System.out.println(car);
       System.out.println(car1);
       System.out.println(car==car1);
    }
}
