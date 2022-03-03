package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.vo.UserVO;

import java.util.List;

/**
 * @author: ZhengTianLiang
 * @date: 2022/03/02  14:13
 * @desc:
 */

@Mapper
public interface UserMapper {

    @Select("select *from tb_user")
    List<UserVO> queryUserList();
}
