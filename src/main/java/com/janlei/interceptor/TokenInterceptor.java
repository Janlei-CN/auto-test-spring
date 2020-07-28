package com.janlei.interceptor;

import com.janlei.annotation.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.UUID;

@Slf4j
public class TokenInterceptor extends HandlerInterceptorAdapter {

    /**
     * The Constant TOKEN. 放在session中的token
     */
    private static final String TOKEN = "token";

    /**
     * 拦截处理程序的执行。在HandlerMapping之后调用，确定适当的处理程序对象，但是在HandlerAdapter调用处理程序之前调用。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();
            Token tokenAnnotation = method.getAnnotation(Token.class);
            if (tokenAnnotation != null) {
                HttpSession session = request.getSession();

                // 创建新的表单提交令牌token,防止表单重复提交
                boolean isGenerate = tokenAnnotation.generate();
                if (isGenerate) {
                    String formToken = UUID.randomUUID().toString();
                    session.setAttribute(TOKEN, formToken);
                    log.info("创建表单提交令牌成功，token:" + formToken);
                    return true;
                }

                // 删除token令牌
                boolean isRemove = tokenAnnotation.remove();
                if (isRemove) {
                    if (isRepeatSubmit(request)) {
                        log.warn("表单不能重复提交:" + request.getRequestURL());
                        return false;
                    }
                    session.removeAttribute(TOKEN);
                }
            }
        } else {
            return super.preHandle(request, response, handler);
        }
        return true;
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        //session中token
        String token = (String) request.getSession().getAttribute(TOKEN);
        if (StringUtils.isEmpty(token)) {
            return true;
        }
        //请求头中获取token
        String reqToken = request.getHeader(TOKEN);
        if (StringUtils.isEmpty(reqToken)) {
            //请求参数request中获取token
            reqToken = request.getParameter(TOKEN);
            if (StringUtils.isEmpty(reqToken)) {
                return true;
            }
        }
        //对比session与前端传递过来的token是否相等
        if (!token.equals(reqToken)) {
            return true;
        }
        return false;
    }
}