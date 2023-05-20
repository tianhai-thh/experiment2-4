package com.tang.controller;

import com.tang.Util.CheckCodeUtil;
import com.tang.pojo.User;
import com.tang.service.impl.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@Controller
@ResponseBody
public class Codecontroller extends HttpServlet {
    @Autowired
    UserServiceimpl service;
    @RequestMapping(value = "/Codecontroller")
    protected void Codecontroller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成验证码
        ServletOutputStream os = response.getOutputStream();
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);

        //存入session
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen",checkCode);
    }

    @RequestMapping(value = "/registerCodecontroller")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取邮箱和密码
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");

        //获取程序生成的验证码，从session获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");


        //比对
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/toregister").forward(request,response);
            return;
        }


        //2.封装为user对象
        System.out.println("email -> " + email);
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        System.out.println(user);
        //3.调用service注册
        boolean flag = service.register(user);

        System.out.println(flag);
        //4.判断注册成功与否
        if(flag){
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("").forward(request,response);
        }else {
            request.setAttribute("register_msg","该邮箱已经注册过");
            request.getRequestDispatcher("/toregister").forward(request,response);
        }

    }
}
