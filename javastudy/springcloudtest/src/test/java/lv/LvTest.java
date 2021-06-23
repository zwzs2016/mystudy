package lv;

import ioc.Config;
import ioc.lv.LvBu;
import ioc.lv.LvConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LvTest {
    //之前执行
    AnnotationConfigApplicationContext acac;
    @Before
    public void before(){
        acac=new AnnotationConfigApplicationContext(LvConfig.class);
        System.out.println("before!");
    }
    @After
    public void after(){
        System.out.println("after!");
        acac.close();
    }
    @Test
    public void testLv(){
        LvBu lvBu = acac.getBean("lvBu", LvBu.class);
        lvBu.fight();
        lvBu.fight1();
    }
}
