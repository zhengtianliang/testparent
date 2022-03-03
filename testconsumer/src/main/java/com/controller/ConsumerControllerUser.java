package com.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.HttpUtils;
import com.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhengTianLiang
 * @date: 2022/03/02  16:26
 * @desc:
 */

@RestController
@RequestMapping(value = "/con")
@Slf4j
public class ConsumerControllerUser {

    @Autowired
    private RestTemplate restTemplate;

//    @Value("")
    private String url = "http://localhost:9003/pro/list";

    @GetMapping(value = "/resttemplate/{id}")
    public List<UserVO> test1(@PathVariable(value = "id")String id){
        log.error("id是"+id);
        // 当托底数据
        List<UserVO> result = new ArrayList<UserVO>();
        result.add(new UserVO());

        Map<String, Object> map = new HashMap<String, Object>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(map, headers);
        ResponseEntity<String> entity = restTemplate.postForEntity(url, request, String.class);
        if (entity != null && 200 == entity.getStatusCodeValue()) {
            log.info(entity.getBody());
            return JSON.parseArray(entity.getBody(), UserVO.class);
        }
        log.error("有错了");
        return null;
    }

    @GetMapping(value = "/httputil")
    public List<UserVO> test2(){
        String post = HttpUtil.post(url, "");
//        return JSON.parseArray(JSON.toJSONString(post), UserVO.class);
        log.info(post);
        return null;
    }
}
