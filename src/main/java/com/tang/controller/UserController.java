package com.tang.controller;

import com.tang.Util.Constants;
import com.tang.pojo.User;
import com.tang.service.impl.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author zjzhou
 * @version 1.0
 */


//@Controller注解用于标示本类为web层控制组件
@Controller
//在默认情况下springmvc的实例都是单例模式，以使用scope域将其注解为每次都创建一个新的实�?
public class UserController {

    @Autowired
    private UserServiceimpl userServiceimpl ;

    //登录
    @RequestMapping("/login")
    public String login(Model model, User user){
        System.out.println("user" + user);
        //调用Service层
        boolean loginType = userServiceimpl.login(user.getEmail(),user.getPassword());
        System.out.println("login ->" + loginType);
        System.out.println("\n\n\n");
        //登陆成功
        if(loginType){
            //如果验证通过,则将用户信息传到前台
            model.addAttribute("user",user);
            //并跳转到index.jsp页面
            return "index";
//            return "forward:/success.jsp";
            //登陆失败
        }else{
            model.addAttribute("err","用户名密码错误！");
            return "login";
        }

    }



    @RequestMapping("/toregister")
    public String toregister(){
        return "register";
    }
    //注册


    //  不要验证码的注册
    @RequestMapping("/register")
    public String register(User user){
        boolean registerType = userServiceimpl.register(user);
        System.out.println("注册 ->" + registerType);
        return "login";
    }

    /**
     * 处理图片显示请求
     * @param fileName
     */
    @RequestMapping("/showPic/{fileName}.{suffix}")
    public void showPicture(@PathVariable("fileName") String fileName,
                            @PathVariable("suffix") String suffix,
                            HttpServletResponse response){
        File imgFile = new File(Constants.IMG_PATH + fileName + "." + suffix);
        responseFile(response, imgFile);
    }

    /**
     * 处理图片下载请求
     * @param fileName
     * @param response
     */
    @RequestMapping("/downloadPic/{fileName}.{suffix}")
    public void downloadPicture(@PathVariable("fileName") String fileName,
                                @PathVariable("suffix") String suffix,
                                HttpServletResponse response){
        // 设置下载的响应头信息
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + "headPic.jpg");
        File imgFile = new File(Constants.IMG_PATH + fileName + "." + suffix);
        responseFile(response, imgFile);
    }

    /**
     * 响应输出图片文件
     * @param response
     * @param imgFile
     */
    private void responseFile(HttpServletResponse response, File imgFile) {
        try(InputStream is = new FileInputStream(imgFile);
            OutputStream os = response.getOutputStream();){
            byte [] buffer = new byte[1024]; // 图片文件流缓存池
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}

