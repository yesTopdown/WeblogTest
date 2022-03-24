package com.example.weblogtest.service.Impl;

import com.example.weblogtest.mapper.TypesMapper;
import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Page;
import com.example.weblogtest.pojo.Type;
import com.example.weblogtest.service.TypesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypesServiceImpl implements TypesService {
    @Resource
    TypesMapper typesMapper;
    Page<Blog> pageType;
    @Override
    public List<Type> findAllTypes() {
        List<Type> types = typesMapper.findAllTypes();
        return types;
    }
   //分页查询

    /**
     * @param id type的id
     * @param page 哪一页
     * @param size 尺寸是
     * @return
     */
    @Override
    public Page<Blog> findBlogsByTypes(Long id, Integer page, Integer size) {
        List<Blog> blogsByTypes = typesMapper.findBlogsByTypes(id, page, size);
        int count= typesMapper.findCountTypes();//总数
        pageType=new Page<>(); //创建page函数
        pageType.setList(blogsByTypes); //加入list集合中
        pageType.setSize(blogsByTypes.size());//当前页的大小
        pageType.setPageNum(page); //当前页
        if(count!=0) {
            if (count % size > 0) {
                pageType.setPages((count / size) + 1);
            } else if (count % size == 0) {
                pageType.setPages(count / size);
            }
            if (page == 0) {
                pageType.setFirstPage(true);//是否是第一页
            }
            if (count % page > 0 && page == (count / page) + 1
                    || count % page == 0 && page == count / page) { //判断是不是最后一页
                pageType.setLastPage(true);
            }
            pageType.setList(blogsByTypes);
        }
        return pageType;
    }


}
