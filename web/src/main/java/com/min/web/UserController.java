package com.min.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户接口")
public class UserController {
    @ApiOperation(tags = "",value = "查询用户信息",notes = "根据姓名查询用户")
    @GetMapping("/user/{name}")
    public String queryUserByName(@PathVariable("name") String name) {

        return "显示数据："+name;
    }


}
