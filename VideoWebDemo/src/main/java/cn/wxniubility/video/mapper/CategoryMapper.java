package cn.wxniubility.video.mapper;

import cn.wxniubility.video.pojo.Category;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.mapper
 * ClassName: CategoryMapper
 *
 * @author: weixuan
 * @Date: 2021/7/3
 * @Time 23:48
 * Description:
 */
public interface CategoryMapper {
    //查询所有
    List<Category> listCategory();
    //根据Id查询分类
    Category findCategoryById(int id);
}
