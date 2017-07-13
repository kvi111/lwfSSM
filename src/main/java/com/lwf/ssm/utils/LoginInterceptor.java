package com.lwf.ssm.utils;

import com.lwf.ssm.model.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lwf on 2017/3/1.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();
        System.out.println("post URL："+url);
        if(!url.equals("")){
            //判断是否已登录
            User loginUser = (User)request.getSession().getAttribute("user");
            if(loginUser == null){
                //无session则是未登录状态
                System.out.println(">>>未登录，请重新登录<<<");
                response.sendRedirect("/user/login");
                return false;
            }
        }
        return true;
        //return super.preHandle(request, response, handler);
    }
    /*private boolean isPassUrl(String url){
        if(!url.endsWith("/login/login")
                && !url.endsWith("/login/chnagePassEntry")
                && !url.endsWith("/login/change_Login")
                && !url.endsWith("/API/Service")
                && !url.endsWith("/API/Service2")
                && !url.endsWith("/province.txt")
                && !url.endsWith("/city.txt")
                && !url.endsWith("/area.txt")
                && !url.endsWith(".xml")
                && !url.endsWith(".js")
                && !url.endsWith(".css") && !url.endsWith(".png")
                && !url.endsWith(".CSS") && !url.endsWith(".CSS")
                && !url.endsWith(".jpg") && !url.endsWith(".gif")
                && !url.endsWith(".JPG") && !url.endsWith(".GIF")){
            return true;
        }

        return false;
    }*/
}
