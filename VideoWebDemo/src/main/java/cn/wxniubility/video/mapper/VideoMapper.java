package cn.wxniubility.video.mapper;

import cn.wxniubility.video.pojo.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.mapper
 * ClassName: VideoMapper
 *
 * @author: weixuan
 * @Date: 2021/7/3
 * @Time 18:03
 * Description:
 */
public interface VideoMapper {
    // 查询所有视频
    List<Video> findAllVideo();
    // 根据类型查询视频 + 分页
    List<Video> pageVideo(@Param("category") int id,@Param("curPage") int curPage, @Param("pageSize") int pageSize);
    // 根据id查询视频信息
    Video findVideoById(int id);
    // 查询视频总数
    int countVideo();
    // 根据视频类型查询视频总数
    int countVideoByCategory(@Param("category") int id);
    // 添加观看次数
    int updateVideoByWatchNub(@Param("id") int id,@Param("watchNub") int watchNub);
}
