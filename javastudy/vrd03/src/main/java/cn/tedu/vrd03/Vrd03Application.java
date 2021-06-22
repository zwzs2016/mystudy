package cn.tedu.vrd03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//组件扫描
@ServletComponentScan
@SpringBootApplication
public class Vrd03Application {

    public static void main(String[] args) {
        SpringApplication.run(Vrd03Application.class, args);
    }

}
