package com.great.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 该方法会在控制器方法前执行，其返回值表示是否中断后续操作。当其返回值为true时，表示继续向下执行；
     * 当其返回值为false时，会中断后续的所有操作（包括调用下一个拦截器和控制器类中的方法执行等）
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取请求路径url
        String url = httpServletRequest.getRequestURI();
        System.out.println(url);
       //判断是否包含admin,表示是否是后端操作
        if (url.endsWith("/admin/index2")){
            return true;
        }

        if (url.contains("admin")){
            //如果是登录页面就放行
            if (url.endsWith("/admin/path/login")||url.endsWith("/admin/CheckCodeServlet")){
                return true;
            }
            //如果是登录操作就放行
            if (url.endsWith("/admin/cAccount")||url.endsWith("/admin/Login")||url.endsWith("admin/deleteAdmin")){
                return true;
            }
            //判断是否登录
            if (null!=httpServletRequest.getSession()&&null!=httpServletRequest.getSession().getAttribute("admin")){
                return true;
            }
            //由于把文件都放在WEB-INF下,所有无法通过重定向来实现跳转，可以通过请求转发来跳转
//            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/admin/jsp/login.jsp");
            httpServletRequest.getRequestDispatcher("/WEB-INF/admin/jsp/login.jsp").forward(httpServletRequest,httpServletResponse);
            System.out.println("后台被拦截");
            return false;
        }else {
            //如果是登录或注册、注销页面就放行
            if (url.endsWith("/user/path/login")||url.endsWith("/user/path/register")||url.endsWith("/user/CheckCodeServlet")){
                return true;
            }
            //如果是前端登录、注册操作就放行
            if (url.endsWith("/user/Login")||url.endsWith("/user/Register")||url.endsWith("user/deleteUser")){
                return true;
            }
            if (null!=httpServletRequest.getSession()&&null!=httpServletRequest.getSession().getAttribute("user")){
                return true;
            }
            //由于把文件都放在WEB-INF下,所有无法通过重定向来实现跳转，可以通过请求转发来跳转
            httpServletRequest.getRequestDispatcher("/WEB-INF/front/jsp/login.jsp").forward(httpServletRequest,httpServletResponse);
            System.out.println("前台被拦截");
            return false;
        }

    }

    /**
     * 该方法会在控制器方法调用之后，且解析视图之前执行。可以通过此方法对请求域中的模型和视图做出进一步的修改
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法会在整个请求完成，即视图渲染结束之后执行。可以通过此方法实现一些资源清理、记录日志信息等工作
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
