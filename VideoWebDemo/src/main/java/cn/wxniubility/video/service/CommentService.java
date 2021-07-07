package cn.wxniubility.video.service;

import cn.wxniubility.video.pojo.Comment;
import cn.wxniubility.video.pojo.ResultInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.service
 * ClassName: CommentService
 *
 * @author: weixuan
 * @Date: 2021/7/4
 * @Time 11:52
 * Description:
 */
public interface CommentService {
    // 查询视频评论
    List<Comment> findCommentById(int id);
    // 查询视频评论总数
    int countCommentById(int id);
    // 添加评论
    ResultInfo addComment(int id,String content);
}
