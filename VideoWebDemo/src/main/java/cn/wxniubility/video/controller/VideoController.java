package cn.wxniubility.video.controller;

import cn.wxniubility.video.pojo.Category;
import cn.wxniubility.video.pojo.Comment;
import cn.wxniubility.video.pojo.ResultInfo;
import cn.wxniubility.video.pojo.Video;
import cn.wxniubility.video.service.CategoryService;
import cn.wxniubility.video.service.CommentService;
import cn.wxniubility.video.service.VideoService;
import cn.wxniubility.video.utils.BaseUtil;
import cn.wxniubility.video.utils.Constants;
import cn.wxniubility.video.utils.PageSupport;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.controller
 * ClassName: VideoController
 *
 * @author: weixuan
 * @Date: 2021/7/3
 * @Time 18:12
 * Description:
 */
@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentService commentService;

    //进入首页
    @RequestMapping("/")
    public String enterHome(Model model){
        //获取所有数据
        List<Video> videos = videoService.findAllVideo();
        model.addAttribute("videoList",videos);
        //设置轮播图
        int count = videoService.countVideo();
        if(count>Constants.CAROUSEL){
            model.addAttribute("CarouselNub",Constants.CAROUSEL);
        }else{
            model.addAttribute("CarouselNub",count);
        }
        //设置导航栏
        List<Category> categories = categoryService.listCategory();
        model.addAttribute("categoryList",categories);
        return "mobile/index";
    }

    //进入视频
    @RequestMapping("/video/{id}")
    public String enterVideo(@PathVariable int id,Model model){
        Video video = videoService.findVideoById(id);
        //添加视频观看次数
        videoService.updateVideoByWatchNub(id,(video.getWatchNub()+1));
        video.setWatchNub(video.getWatchNub()+1);
        //添加视频评论
        List<Comment> comments = commentService.findCommentById(id);
        int countComment = commentService.countCommentById(id);
        model.addAttribute("commentList",comments);
        model.addAttribute("countComment",countComment);
        model.addAttribute("video",video);
        return "mobile/video";
    }

    //分类
    @RequestMapping("/video/category/{cid}")
    public String listCategory(@PathVariable int cid,Model model){
        List<Category> categories = categoryService.listCategory();
        model.addAttribute("categoryList",categories);
        Category category = categoryService.findCategoryById(cid);
        model.addAttribute("category",category);
        return "mobile/category";
    }

    //分页
    @RequestMapping("/video/page/{id}/{page}")
    @ResponseBody
    public String pageVideo( @PathVariable int id,
                             @PathVariable int page,
                            ResultInfo resultInfo,
                            PageSupport pageSupport) {
        //获取数据
        List<Video> Videos = videoService.pageVideo(id,page);
        resultInfo.setData(Videos);
        //设置分页
        pageSupport.setPageSize(Constants.PAGESIZE);
        pageSupport.setTotalCount(videoService.countVideoByCategory(id));
        resultInfo.setPages(pageSupport.getTotalPageCount());
        return JSON.toJSONString(resultInfo);
    }
    //视频推荐
    @RequestMapping("/video/recommend")
    @ResponseBody
    public String recommendVideo(){
        List<Video> videos = videoService.findAllVideo();
        for (Video video : videos) {
            int count = commentService.countCommentById(video.getId());
            video.setCountComment(count);
        }
        List<Video> recommends = new ArrayList<>();
        if(videoService.countVideo() > Constants.RECOMMEND){
            int[] random = BaseUtil.getRandom(videoService.countVideo());
            for (int i : random) {
                recommends.add(videos.get(i));
            }
        }else{
            return JSON.toJSONString(videos);
        }
        return JSON.toJSONString(recommends);
    }
    //发送弹幕
    @RequestMapping("/video/comment/{id}")
    @ResponseBody
    public String sendComment(@PathVariable int id, String content,
                              HttpSession session,ResultInfo resultInfo){
        Long sessionDate = (Long) session.getAttribute("sessionDate");
        if(sessionDate==null) {
            resultInfo = commentService.addComment(id, content);
            session.setAttribute("sessionDate",System.currentTimeMillis());
        }else{
            long min = (System.currentTimeMillis()-sessionDate)/1000;
            if(min>=Constants.COMMENTCD){
                resultInfo = commentService.addComment(id, content);
                session.setAttribute("sessionDate",System.currentTimeMillis());
            }else{
                resultInfo.setFlag(false);
                resultInfo.setMessage("操作过于频繁,请"+(Constants.COMMENTCD-min)+"秒后再试~");
            }
        }
        return JSON.toJSONString(resultInfo);
    }
    //获取评论区
    @RequestMapping("/comment/{id}")
    @ResponseBody
    public String getComment(@PathVariable int id){
        return JSON.toJSONString(commentService.findCommentById(id));
    }
}
