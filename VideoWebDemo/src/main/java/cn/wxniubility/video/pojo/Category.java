package cn.wxniubility.video.pojo;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.pojo
 * ClassName: Category
 *
 * @author: weixuan
 * @Date: 2021/7/3
 * @Time 13:29
 * Description:
 */
public class Category {
    private int id; //分类id
    private String category;//分类名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
