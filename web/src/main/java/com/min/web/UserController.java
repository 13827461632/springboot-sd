package com.min.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{name}")
    public String queryUserByName(@PathVariable("name") String name) {

        return "显示数据："+name;
    }


}
