package cn.tedu.vrd03;

import cn.tedu.vrd03.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns = {"/vrd/send.html","/vrd/banner.html","/delete"})
public class MyFilter implements Filter {
    public void destroy() {//销毁方法
    }
    //当客户端请求了过滤请求路径时 调用
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        //得到session
        HttpSession session=request.getSession();
        //取出里面保存的user对象
        User user=(User) session.getAttribute("user");
        if(user!=null){
            chain.doFilter(req, resp);
        }else {
            System.out.println("拦截了请求");
            //重定向到登录页面
            response.sendRedirect("/vrd/login.html");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
