package cn.tedu.cppfoto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CppfotoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CppfotoApplication.class, args);
    }

}
