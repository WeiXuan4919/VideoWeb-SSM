package cn.wxniubility.video.pojo;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.pojo
 * ClassName: Comment
 *
 * @author: weixuan
 * @Date: 2021/7/3
 * @Time 13:29
 * Description:
 */
public class Comment {
    private int id; //评论id
    private int vid; //视频id
    private String commenttext; //评论内容
    private Date commentdate; //评论时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public Date getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }
}
