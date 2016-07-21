package com.ecare.web.interceptor;

import com.ecare.web.redis.RedisDao;
import com.ecare.web.util.ResultUtil;
import com.ecare.web.vo.Constant.Constant;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by L on 2016/7/21.
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisDao redisDao;
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        int userId=Integer.valueOf(httpServletRequest.getParameter("user_id").toString());
        String token=httpServletRequest.getParameter("token").toString();
        if(token.equals(redisDao.getToken(userId))){
            return true;
        }
        httpServletResponse.setHeader("content-type","application/json");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().append("{\"code\": 400, \"message\": \"token验证失败\", \"data\": null}");
        return false;
    }
}
