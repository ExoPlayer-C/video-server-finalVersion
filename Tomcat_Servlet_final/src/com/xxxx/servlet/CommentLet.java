// 返回特定ID视频的评论区的所有评论
package com.xxxx.servlet;
import entity.CommentBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
/*
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

//import com.service.Service;

@WebServlet("/Com")
public class CommentLet extends HttpServlet {

    private static final long serialVersionUID = 9036889586892331384L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.getWriter().write("Login success");
        // request是客户端的GET报文，数据是在请求中的，不是通过data传来的
        String videoId = request.getParameter("username");
        videoId = new String(videoId.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(videoId);

        //新建服务对象，提供业务逻辑服务
        Services service = new Services();

        // 给我当前视频的评论
        List<CommentBean> v = service.getComment(videoId);
        if( v.size()>0 ){
            System.out.println("get comment success");
            //request.getSession().setAttribute("username", username);
        }else{
            System.out.println("get comment fail");
        }

        //返回信息到客户端
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if( v.size()>=0 ){
            out.println("true");
            // TODO 这怎么传呢？
            out.println(v);
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