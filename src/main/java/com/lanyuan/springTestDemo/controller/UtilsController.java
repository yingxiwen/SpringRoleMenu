package com.lanyuan.springTestDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Controller
@RequestMapping("/checkcode")
public class UtilsController {

    @RequestMapping("/getCheckcode")
    public void checkcode(HttpServletResponse response, HttpSession session) throws Exception{
        //image 代表一副验证码图片
        /*
        第一个参数 宽
        第二个参数 高
        第三个参数 类型
         */
        int width=100;
        int height=50;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //获取画笔工具 一系列工具的集合
        Graphics graphics = image.getGraphics();
        //设置粉色
        graphics.setColor(Color.pink);
        //0,0代表从矩形左上角开始
        graphics.fillRect(0,0,width,height);

        //输出4 个验证码字符
        graphics.setColor(Color.BLACK);

        String s="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            int num = random.nextInt(s.length());
            char c = s.charAt(num);
            sb.append(c);
            graphics.drawString(c+"",width/5*i,height/2);
        }
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("login_code",sb.toString());

        graphics.setColor(Color.green);
        for (int i = 1; i <= 10; i++) {
            int x1=random.nextInt(width);
            int x2=random.nextInt(width);
            int y1=random.nextInt(height);
            int y2=random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }

        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    @RequestMapping("/getCheckcodeStr")
    public String getCheckcodeStr(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        Object login_code1 = servletContext.getAttribute("login_code");
        if (login_code1!=null){
            return login_code1.toString();
        }
        return null;
    }
}
