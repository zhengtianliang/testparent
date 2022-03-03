package com.pojo;

import lombok.Data;

/**
 * @author: ZhengTianLiang
 * @date: 2022/03/02  16:16
 * @desc:
 */

@Data
public class User {
    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;
}

