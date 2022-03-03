package com.controller;

import com.annotation.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.UserService;
import com.vo.UserVO;

import java.util.List;

/**
 * @author: ZhengTianLiang
 * @date: 2022/03/02  14:00
 * @desc:
 */

@RestController
@RequestMapping(value = "/pro")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/list")
    @OperationLog(category = "操作大类",subcategory = "操作子类",desc = "描述",type = "测试类型1")
    public List<UserVO> list(){
        return userService.queryList();
    }
}
