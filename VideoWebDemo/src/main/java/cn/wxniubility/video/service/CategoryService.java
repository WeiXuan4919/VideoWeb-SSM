package cn.wxniubility.video.service;

import cn.wxniubility.video.pojo.Category;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.service
 * ClassName: CategoryService
 *
 * @author: weixuan
 * @Date: 2021/7/4
 * @Time 2:35
 * Description:
 */
public interface CategoryService {
    //查询所有
    List<Category> listCategory();
    //根据Id查询分类
    Category findCategoryById(int id);
}
