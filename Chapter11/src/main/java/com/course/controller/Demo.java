package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@Api(value = "v1",description = "这是我的第一个版本的的demo")
@RequestMapping(value = "/v1")
public class Demo {

    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "/getUserCount",httpMethod = "GET")
    public int getUserList(){
         return   template.selectOne("getUserCount");
    }


    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
        int r =   template.insert("addUser",user);
        return r;
    }

    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){
        int r =template.update("updateUser",user);
        return r;
    }


    @RequestMapping(value = "deleteUser",method = RequestMethod.POST)
    public int deluser(@RequestParam int id ){
        return template.delete("deleteUser",id);
    }
}
