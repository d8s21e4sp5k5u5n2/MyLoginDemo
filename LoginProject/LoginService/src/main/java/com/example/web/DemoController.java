package com.example.web;

import com.example.entity.Users;
import com.example.entity.UserLoginLog;
import com.example.service.UserLoginLogService;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
//@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
//        maxAge = 3600L, methods={RequestMethod.GET, RequestMethod.POST,RequestMethod.HEAD})
@RequestMapping("/user")
public class DemoController {

    @Resource
    private UserService userService;

    @Resource
    private UserLoginLogService userLoginLogService;


    @RequestMapping("/login")
    public String showIndex() {
        return "login";
    }

    @RequestMapping("/logDemo")
    public String logDemo() {
        return "loginLog";
    }

    @RequestMapping("/sign")
    public String sign() {
        return "signIn";
    }

    @RequestMapping("/toSignIn")
    public String toSignIn(Users users) {
        userService.save(users);
        return "login";
    }

    @RequestMapping("/toLogin")
    public String toLogin(Users users, Model model) {
        Map<String, String> map = userService.login(users);
        String code = map.get("resultCode");
        if (code.equals("200")) {
            List<UserLoginLog> logList = userLoginLogService.loginLog();
            model.addAttribute("logList",logList);
//            response.setHeader("redirectUrl","loginLog");
//            response.setHeader("enableRedirect","true");
//            response.flushBuffer();
            return "loginLog";
        } else {
//            response.setHeader("redirectUrl","signIn");
//            response.setHeader("enableRedirect","true");
//            response.flushBuffer();
            return "login";
        }
    }

//    @RequestMapping("/getLoginLog")
////    public String getLoginLog(Model model) {
////        List<UserLoginLog> logList = userLoginLogService.loginLog();
////        System.out.println(logList);
////        model.addAttribute(logList);
////        return "/loginLog";
////    }
}
