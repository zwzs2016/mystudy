package cn.tedu.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {

    @Test
    void contextLoads() {
        int i=1,j=0;
        j=i++*2;
        System.out.println("j"+j);
    }

}
