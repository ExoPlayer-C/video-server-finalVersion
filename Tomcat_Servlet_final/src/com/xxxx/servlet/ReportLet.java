// 用户点击举报按钮触发该servlet 往数据库中写入举报信息
package com.xxxx.servlet;
import service.Services;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//import com.service.Service;

@WebServlet("/Rep")
public class ReportLet extends HttpServlet {

    private static final long serialVersionUID = 9036889586892331384L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request是客户端的GET报文，数据是在请求中的，不是通过data传来的
        String videoId = request.getParameter("username");
        videoId = new String(videoId.getBytes("ISO-8859-1"),"UTF-8");
        String commentId = request.getParameter("CommentId");
        commentId = new String(commentId.getBytes("ISO-8859-1"),"UTF-8");
        String userId = request.getParameter("userId");
        userId = new String(userId.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(videoId+":"+commentId+":"+userId);

        //新建服务对象，提供业务逻辑服务
        Services service = new Services();

        // 投诉数据库更新
        boolean b = service.setReport(videoId,commentId,userId);
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
        // TODO 自动生成的方法存根 不用写POST
    }

}