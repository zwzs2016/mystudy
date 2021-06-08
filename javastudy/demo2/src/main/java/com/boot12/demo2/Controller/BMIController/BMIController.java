package com.boot12.demo2.Controller.BMIController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BMIController {
//    value || path
    @RequestMapping(path="/bmi",produces = "text/html;charset=utf8")
    @ResponseBody
    public String bmi(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String height=request.getParameter("h");
        String weight=request.getParameter("w");
        float bmi = 80 / Float.parseFloat(height)*Float.parseFloat(weight);
        String result="";
        if(bmi<18.5){
            result="偏瘦";
        }else if(bmi<24 && bmi>=18.5){
            result="正常";
        }else if(bmi<24 && bmi>=28){
            result="偏胖";
        }else {
            result="肥胖";
        }
//        response.setContentType("text/html;charset=utf8");
//        response.getWriter().println(result);
        return result;
    }
}
