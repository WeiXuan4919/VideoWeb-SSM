package cn.wxniubility.video.mapper;

import cn.wxniubility.video.pojo.Comment;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.mapper
 * ClassName: CommentMapper
 *
 * @author: weixuan
 * @Date: 2021/7/4
 * @Time 11:47
 * Description:
 */
public interface CommentMapper {
    // 查询视频评论
    List<Comment> findCommentById(int id);
    // 查询视频评论总数
    int countCommentById(int id);
    // 添加评论
    int addComment(Comment comment);
}
