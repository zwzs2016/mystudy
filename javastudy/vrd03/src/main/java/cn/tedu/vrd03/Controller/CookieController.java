package cn.tedu.vrd03.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CookieController {
    @RequestMapping("/cookie")
    public String cookie(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for (Cookie c:cookies) {
                String name=c.getName();
                String value=c.getValue();
                System.out.println("name="+name);
                System.out.println("value="+value);
            }
        }
        return "接收到了Cooike";
    }
}
