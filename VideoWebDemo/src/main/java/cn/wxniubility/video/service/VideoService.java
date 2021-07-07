package cn.wxniubility.video.service;

import cn.wxniubility.video.pojo.Category;
import cn.wxniubility.video.pojo.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.service
 * ClassName: VideoService
 *
 * @author: weixuan
 * @Date: 2021/7/3
 * @Time 18:11
 * Description:
 */
public interface VideoService {
    // 查询所有视频
    List<Video> findAllVideo();
    // 根据类型查询视频 + 分页
    List<Video> pageVideo(int id, int curPage);
    // 根据id查询视频信息
    Video findVideoById(int id);
    // 查询视频总数
    int countVideo();
    // 根据视频类型查询视频总数
    int countVideoByCategory(int id);
    // 添加观看次数
    int updateVideoByWatchNub(int id,int watchNub);
}
