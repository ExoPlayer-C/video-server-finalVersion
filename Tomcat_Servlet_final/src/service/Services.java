// 为Servlet提供各种服务，比如数据库查询服务，或者是邮件发送，或者是各种算法逻辑处理
package service;

import entity.CommentBean;
import entity.VideoBean;

import java.util.List;

public class Services {

    /*普通0 vip1 管理员2
        密码错误 -1
        */
    public int login(String name,String password){
        /*这里应该连接数据库进行检验*/
        return 0;
    }

    /*注册成功 true
    账号已存在 false
    */
    public boolean register(String name,String password){
        return true;
    }

    /*返回视频列表*/
    public List<VideoBean> getVideo(String name, String area, String up){
        List<VideoBean> l=null;
        return l;
    }

    /*返回评论列表*/
    public List<CommentBean> getComment(String videoId){
        List<CommentBean> l=null;
        return l;
    }

    /*返回评论列表*/
    public boolean setReport(String videoId,String commentId,String userId){
        return true;
    }

    public boolean setPersonalInfo(String[] infos){
        return true;
    }

}

