package com.xxxx.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.Services;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogLet", value = "/Log")
public class LogLet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // request是客户端的GET报文，数据是在请求中的，不是通过data传来的
        String username = request.getParameter("username");
        username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
        String password = request.getParameter("password");
        password = new String(password.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(username + ":" + password);

        //新建服务对象，提供业务逻辑服务
        Services service = new Services();

        //验证处理
        int level = service.login(username, password);
        if( level>=0 ){
            System.out.println("log success");
            //request.getSession().setAttribute("username", username);
        }else{
            System.out.println("log fail");
        }

        // out返回信息到客户端
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if( level>=0 ){
            out.println("true");
            out.println(level);
        }else{
            out.println("false");
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 不用写POST
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        resp.getWriter().write("hello squy");
        doGet(req,resp);
    }
}
