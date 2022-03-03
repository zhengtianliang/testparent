package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ZhengTianLiang
 * @date: 2022/03/02  16:37
 * @desc:
 */
@Component
public class RestTemplateBean {

    @Bean
//    @LoadBalance
    public RestTemplate getResttemplate(){
        return new RestTemplate();
    }
}
