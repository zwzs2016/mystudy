package ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac=new AnnotationConfigApplicationContext(Config.class);
        acac.getBean("hero",Hero.class);
    }
}
