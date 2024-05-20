package com.kh.homepage.common.config;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.google.gson.Gson;

@Aspect
@Component
public class LoggingAop {

    private static Logger logger = LoggerFactory.getLogger(LoggingAop.class);

    @Before("execution(* com.kh.homepage.*.controller.*.*(..))")
    public void logRequestParams() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();

            logger.info("Request Parameters: {}",  new Gson().toJson(request.getParameterMap()));
        }
    }

    @AfterReturning(pointcut = "execution(* com.kh.homepage.*.controller.*.*(..))", returning = "result")
    public void logResponseData(Object result) {
        logger.info("Response Data: {}", result);
    }

}
