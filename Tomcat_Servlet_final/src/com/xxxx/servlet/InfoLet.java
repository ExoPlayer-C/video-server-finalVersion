// 修改个人信息时使用
package com.xxxx.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Services;

import java.io.IOException;
import java.io.PrintWriter;

/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

//import com.service.Service;


@WebServlet("/Inf")
public class InfoLet extends HttpServlet {

    private static final long serialVersionUID = 9036889586892331384L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.getWriter().write("Login success");
        // request是客户端的GET报文，数据是在请求中的，不是通过data传来的
        String[] infos=new String[10];
        String username = request.getParameter("username");
        username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
        String password = request.getParameter("password");
        password = new String(password.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(username + ":" + password);

        //新建服务对象，提供业务逻辑服务
        Services service = new Services();

        //验证处理
        boolean b = service.setPersonalInfo(infos);
        if( b ){
            System.out.println("set report success");
            //request.getSession().setAttribute("username", username);
        }else{
            System.out.println("set report fail");
        }

        //返回信息到客户端
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if( b ){
            out.println("true");
        }else{
            out.println("false");
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        resp.getWriter().write("Login success");
    }

}