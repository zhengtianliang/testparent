package com.service;



import com.vo.UserVO;

import java.util.List;

/**
 * @author: ZhengTianLiang
 * @date: 2022/03/02  14:09
 * @desc:
 */
public interface UserService  {

    List<UserVO> queryList();
}
