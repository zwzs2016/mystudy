package zhang;

import ioc.lv.LvConfig;
import ioc.zhang.ZhangConfig;
import ioc.zhang.ZhangFei;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestZhang {
    //之前执行
    AnnotationConfigApplicationContext acac;
    @Before
    public void before(){
        acac=new AnnotationConfigApplicationContext(ZhangConfig.class);
        System.out.println("before!");
    }
    @After
    public void after(){
        System.out.println("after!");
        acac.close();
    }

    @Test
    public void run(){
        ZhangFei zhangFei=acac.getBean("zhangFei",ZhangFei.class);
        zhangFei.fight();
    }
}
