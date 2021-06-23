package san;

import ioc.Config;
import ioc.Hero;
import ioc.san.DragonBlade;
import ioc.san.GuanYu;
import ioc.san.SanConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class sanTest {

    //之前执行
    AnnotationConfigApplicationContext acac;
    @Before
    public void before(){
        acac=new AnnotationConfigApplicationContext(SanConfig.class);
        System.out.println("before!");
    }
    @After
    public void after(){
        System.out.println("after!");
        acac.close();
    }
    @Test
    public void sanTest(){
        DragonBlade blade = acac.getBean("blade1", DragonBlade.class);
        GuanYu guan = acac.getBean("guanYu", GuanYu.class);
        guan.fight();
    }
}
