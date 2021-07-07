package cn.wxniubility.video.pojo;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.pojo
 * ClassName: video
 *
 * @author: weixuan
 * @Date: 2021/7/3
 * @Time 13:27
 * Description:
 */
public class Video {
    private int id; //视频编号
    private String videoName; //视频名字
    private int category; //视频分类
    private int watchNub; //观看次数
    private int collection; //点赞次数
    private String videoPath; //视频地址
    private String coverPath; //封面地址
    private Date creationDate; //创建时间

    private int countComment;//评论次数

    public int getCountComment() {
        return countComment;
    }

    public void setCountComment(int countComment) {
        this.countComment = countComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getWatchNub() {
        return watchNub;
    }

    public void setWatchNub(int watchNub) {
        this.watchNub = watchNub;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", videoName='" + videoName + '\'' +
                ", category=" + category +
                ", watchNub=" + watchNub +
                ", collection=" + collection +
                ", videoPath='" + videoPath + '\'' +
                ", coverPath='" + coverPath + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
