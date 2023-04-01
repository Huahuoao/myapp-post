package com.huahuo.potato.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huahuo.potato.common.ResponseResult;
import com.huahuo.potato.pojo.User;
import com.huahuo.potato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @作者 花火
 * @创建日期 2023/3/29 11:39
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class Usercontroller {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User one = userService.getOne(queryWrapper);
        HashMap map = new HashMap<>();
        if (one == null) return ResponseResult.errorResult(301, "用户未注册");
        if (user.getPassword().equals(one.getPassword())) {
            map.put("msg", "登录成功");
            map.put("id", one.getId());

            return ResponseResult.okResult(map);
        }
        return ResponseResult.errorResult(302, "密码错误");
    }
}
