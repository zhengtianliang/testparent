package com.service.impl;

import com.mapper.UserMapper;
import com.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.UserService;

import java.util.List;

/**
 * @author: ZhengTianLiang
 * @date: 2022/03/02  14:10
 * @desc:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @author: ZhengTianLiang
     * @date: 2022/03/02  14:19
     * @desc: 查询列表
     */
    public List<UserVO> queryList() {
        return userMapper.queryUserList();
    }
}
