package cn.wxniubility.video.service.impl;

import cn.wxniubility.video.mapper.CategoryMapper;
import cn.wxniubility.video.mapper.VideoMapper;
import cn.wxniubility.video.pojo.Category;
import cn.wxniubility.video.pojo.Video;
import cn.wxniubility.video.service.VideoService;
import cn.wxniubility.video.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.service.impl
 * ClassName: VideoServiceImpl
 *
 * @author: weixuan
 * @Date: 2021/7/3
 * @Time 18:11
 * Description:
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Video> findAllVideo() {
        return videoMapper.findAllVideo();
    }

    @Override
    public List<Video> pageVideo(int id, int curPage) {
        return videoMapper.pageVideo(id,(curPage-1)*Constants.PAGESIZE,Constants.PAGESIZE);
    }

    @Override
    public Video findVideoById(int id) {
        return videoMapper.findVideoById(id);
    }

    @Override
    public int countVideo() {
        return videoMapper.countVideo();
    }

    @Override
    public int countVideoByCategory(int id) {
        return videoMapper.countVideoByCategory(id);
    }

    @Override
    public int updateVideoByWatchNub(int id, int watchNub) {
        return videoMapper.updateVideoByWatchNub(id,watchNub);
    }
}
