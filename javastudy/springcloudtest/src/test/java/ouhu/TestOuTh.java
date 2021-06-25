package ouhu;

import ioc.lv.LvBu;
import ioc.lv.LvConfig;
import ioc.ouhe.GuanYu;
import ioc.ouhe.OuThConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestOuTh {
    //之前执行
    AnnotationConfigApplicationContext acac;
    @Before
    public void before(){
        acac=new AnnotationConfigApplicationContext(OuThConfig.class);
        System.out.println("before!");
    }
    @After
    public void after(){
        System.out.println("after!");
        acac.close();
    }
    @Test
    public void testLv(){
        GuanYu guanYu = acac.getBean("guanYu", GuanYu.class);
        guanYu.fight();
    }
}
