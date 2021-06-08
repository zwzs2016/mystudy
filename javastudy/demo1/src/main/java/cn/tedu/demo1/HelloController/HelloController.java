package cn.tedu.demo1.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public void hello(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        PrintWriter pw=response.getWriter();
        pw.println("<h1>恭喜!请求成功!</h>");
        pw.close();
    }
    @RequestMapping("/helloinfo")
    public void hi(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String info=request.getParameter("info");
        System.out.println("请求参数:"+info);
        response.setContentType("text/html;charset=utf8");
        PrintWriter pw=response.getWriter();
        pw.println("<h1>服务器接收到:"+info+"</h>");
        pw.close();
    }
}
