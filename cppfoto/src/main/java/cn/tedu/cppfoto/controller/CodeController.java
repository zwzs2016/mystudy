package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.utils.ImgCheckCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/util")
public class CodeController {
    public static String CODE_SESSION_NAME="imgCode";

    /**
     * 生成验证码
     */
    @RequestMapping("/getCodeImg")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImgCheckCode imgCheckCode=new ImgCheckCode();
        String code=imgCheckCode.getRandomCodeStr();
        BufferedImage buffImg= imgCheckCode.getImgCode(code);
        System.out.println("Code is " +code);
        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute(CODE_SESSION_NAME,code);
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = response.getOutputStream();
        try {
            ImageIO.write(buffImg, "jpeg", sos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sos.close();
    }

    /**
     * 检查提交的验证码是否正确
     */
    @RequestMapping(value ="/checkCode")
    public boolean checkCode(HttpServletRequest request , String code){
        boolean result=false;
        String sessionCode=request.getSession().getAttribute(CODE_SESSION_NAME).toString();
        code=code.toUpperCase();
        if(sessionCode.equals(code)){
            result=true;
        }else{
            result=false;
        }
        return result;
    }


}

