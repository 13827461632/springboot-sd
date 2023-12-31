package com.min.web;

import com.min.comm.dto.User;
import com.min.comm.error.ErrorEnum;
import com.min.comm.exception.BizException;
import com.min.comm.logaop.MethodLog;
import com.min.comm.response.ResultVO;
import com.min.dao.dataobject.UserDO;
import com.min.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "用户接口1")
public class UserController {


    @Resource
    private UserService userService;

    @MethodLog
    @ApiOperation(value = "查询用户", notes = "根据姓名查询用户")
    @GetMapping("/user/{name}")
    public String queryUserByName(@PathVariable String name) {
        UserDO user = userService.queryUserByName(name);

        try {
            return "查找的用户为：" + user.getName();
        } catch (Exception e) {
            //TODO 定位问题打印异常信息（开发看的）
            System.out.println("记录exception:" + e.getMessage());
            //TODO 自定义异常（抛给前台看的）
            throw new BizException(ErrorEnum.DATA_ERROR.getCode(), "根据姓名查询用户可能为空，请检查");
        }

    }

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @GetMapping("/user/all")
    public ResultVO<List<User>> queryAllUser() {
        List<User> users = userService.queryAll();
        if (CollectionUtils.isEmpty(users)) {
            return ResultVO.Result(ErrorEnum.DATA_NOT_FOUND, null);
        }

        return ResultVO.Result(ErrorEnum.SUCCESS, users);

    }

    @ApiOperation(value = "新增用户", notes = "根据用户名和ID添加新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userName", value = "用户名",
                    required = true),
            @ApiImplicitParam(paramType = "query", name = "userID", value = "用户ID",
                    required = true)
    })
    @PostMapping("/user")
    public String addUser(@RequestParam String userName, @RequestParam Integer userID) {
        userService.createUser(userName);
        return "新增用户：" + userName + "，ID：" + userID;
    }

    @ApiOperation(value = "修改用户信息", notes = "更新用户信息")
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User userDTO) {
        return userDTO.toString();
    }

}
