package com.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: ZhengTianLiang
 * @date: 2022/03/02  16:32
 * @desc:
 */

//@Component
@Slf4j
public class TokenFilter extends OncePerRequestFilter {

    /**
     * true开启token校验；false关闭token校验
     */
// @Value("${token.enabled}")
    private boolean enabled = true;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        boolean swflag = request.getRequestURI().contains("swagger-")
                || request.getRequestURI().contains("api-docs") ||
                request.getRequestURI().contains("favicon");

        if (!enabled || swflag) {
            try {
                filterChain.doFilter(request, response);
            } catch (IOException e) {
                throw new RuntimeException("该方法为post请求，不可用get方式加参数");
            }
            return;
        }

        try {
            // 优先获取请求头获取
            String accessToken = request.getHeader("X-token");
            //Cookie [] cookies = request.getCookies();

//            if (StrUtil.isNotEmpty(accessToken)) {
//                accessToken = accessToken.trim();
//            }
            log.info("accessToken 请求头 {}", accessToken);
            // 没有携带token
            if (StringUtils.isEmpty(accessToken)) {
                log.error("accessToken 不能为空");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                logger.info("请求未授权");
                return;
            }


            filterChain.doFilter(request, response);
        } finally {
            System.out.println("finally代码");
        }
    }
}
