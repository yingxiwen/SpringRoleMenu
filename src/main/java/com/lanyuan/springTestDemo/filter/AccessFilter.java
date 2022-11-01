package com.lanyuan.springTestDemo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //过滤处理
        //servletRequest 是个接口，HttpServletRequest 是实现，但是有些方法是HttpServletRequest独有的，如：getSession
        //HttpServletRequest接口是继承servletRequest接口，增加了和http相关的方法
        HttpServletRequest httpRequest= (HttpServletRequest) request;
        String origin = httpRequest.getHeader("Origin");
        HttpServletResponse httpResponse= (HttpServletResponse) response;
        httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin",origin);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
