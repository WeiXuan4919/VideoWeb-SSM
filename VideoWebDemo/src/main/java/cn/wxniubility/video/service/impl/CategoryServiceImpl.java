package cn.wxniubility.video.service.impl;

import cn.wxniubility.video.mapper.CategoryMapper;
import cn.wxniubility.video.pojo.Category;
import cn.wxniubility.video.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.service.impl
 * ClassName: CategoryServiceImpl
 *
 * @author: weixuan
 * @Date: 2021/7/4
 * @Time 2:35
 * Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> listCategory() {
        return categoryMapper.listCategory();
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryMapper.findCategoryById(id);
    }
}
