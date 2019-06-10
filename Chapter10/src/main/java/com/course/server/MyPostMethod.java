package com.course.server;

import com.course.Bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "z这是我全部的post请求")
public class MyPostMethod {

    // 这个变量是用来装我们cookies信息的
    private static Cookie cookie;

    // 用户登录成功获取到cookies，然后访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam(value = "userName",required = true) String userName,@RequestParam(value = "password",required = true) String password){

        if (userName.equals("zhangsan") && password.equals("123456")){
            cookie = new javax.servlet.http.Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功了";
        }
        return "用户名或者是密码错误";
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User u){

        User user = new User();
//        获取cookies
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true") && u.getUserName().equals("zhangshang") && u.getPassword().equals("123456")){

                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }

}
