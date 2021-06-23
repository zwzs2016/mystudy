package ioc;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestIoc {
    //之前执行
    AnnotationConfigApplicationContext acac;
    @Before
    public void before(){
        acac=new AnnotationConfigApplicationContext(Config.class);
        System.out.println("before!");
    }
    @After
    public void after(){
        System.out.println("after!");
        acac.close();
    }
    @Test
    public void test(){
        acac.getBean("hero",Hero.class);
    }
}
