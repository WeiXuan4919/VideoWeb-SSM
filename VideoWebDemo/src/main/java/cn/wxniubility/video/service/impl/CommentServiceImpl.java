package cn.wxniubility.video.service.impl;

import cn.wxniubility.video.mapper.CommentMapper;
import cn.wxniubility.video.pojo.Comment;
import cn.wxniubility.video.pojo.ResultInfo;
import cn.wxniubility.video.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.service.impl
 * ClassName: CommentServiceImpl
 *
 * @author: weixuan
 * @Date: 2021/7/4
 * @Time 11:52
 * Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findCommentById(int id) {
        return commentMapper.findCommentById(id);
    }

    @Override
    public int countCommentById(int id) {
        return commentMapper.countCommentById(id);
    }

    @Override
    public ResultInfo addComment(int id,String content) {
        ResultInfo resultInfo = new ResultInfo();
        int res=0;
        //实例化评论对象
        if (content != null && !"".equals(content)) {
            Comment comment = new Comment();
            comment.setVid(id);
            comment.setCommenttext(content);
            comment.setCommentdate(new Date());
            //添加评论
            res = commentMapper.addComment(comment);
        }
        if(res>0){
            resultInfo.setFlag(true);
            resultInfo.setMessage("发布成功!");
        }else {
            resultInfo.setFlag(false);
            resultInfo.setMessage("发布失败!");
        }
        return resultInfo;
    }
}
