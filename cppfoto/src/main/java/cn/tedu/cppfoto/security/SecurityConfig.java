//package cn.tedu.cppfoto.security;
//
//import cn.tedu.cppfoto.service.Impl.UserDetailServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailServiceImpl userDeatilService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDeatilService);
//    }
//
//    //设置授权范围的方法
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //super.configure(http);
//        http.csrf().disable() //禁用防跨域功能
//                    .authorizeRequests() //开始进行授权攻击功能
//                    .antMatchers(
//                                        "/js/*",
//                                        "/css/*",
//                                        "/img/**",
//                                        "/bower_components/**",
//                                        "/login.html",
//                                        "/register.html",
//                                        "/register"
//                                ).permitAll()//
//                                .anyRequest()//其他路径
//                                .authenticated()//需要登录
//                                .and().formLogin()//如果登录使用表单验证
//                                .loginPage("/login.html")
//                                .loginProcessingUrl("/login")//配置提交登录的路径
//                                .failureUrl("/login.html?error")//当登录失败后，跳转的页面
//                                .defaultSuccessUrl("/index_student.html")//登录成功时默认显示的页面
//                                .and().logout()//开始设置登出李佳
//                                    //登出路径
//                                .logoutUrl("/logout")
//                                .logoutSuccessUrl("/logout");
//        //以下这句就可以控制单个用户只能创建一个session，也就只能在服务器登录一次
//        //http.sessionManagement().maximumSessions(1).expiredUrl("/login");
//    }
//}
