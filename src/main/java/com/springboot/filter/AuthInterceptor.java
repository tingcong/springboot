package com.springboot.filter;

import com.springboot.common.annotation.Authentication;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 权限验证
 * Created by htc on 2017/9/30.
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("拦截前。。。");
        // 如果不是映射到方法直接通过
        if (!(o instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) o;
        Method method = handlerMethod.getMethod();

        //判断接口是否需要验证权限
        Authentication authentication = method.getAnnotation(Authentication.class);
        //判断该方法是否有@Authentication注解，有则需要验证.没有直接通过
        if (null != authentication) {
            switch (authentication.authentication()) {
                case "visitor":
                    System.out.println("您的身份为：visitor");
                    break;
                case "ordinary":
                    System.out.println("您的身份为：ordinary");
                    break;
                case "membership":
                    System.out.println("您的身份为：membership");
                    break;
                default:
                    System.out.println("您的身份为：ERROR");
            }
            //验证权限
            return true;
        }
        System.out.println("没有该注解。。。");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截中。。。");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("拦截后。。。");
    }
}
