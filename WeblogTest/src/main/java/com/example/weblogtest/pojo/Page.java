package com.example.weblogtest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Page <T>{
    public static final Integer PAGE_SIZE = 4;
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size=PAGE_SIZE;
    //总页码
    private int total;
    //总页数
    private int pages;

    //结果集(每页显示的数据)
    private List<T> list;

    //是否为第一页
    public boolean isFirstPage = false;

    //是否为最后一页
    public boolean isLastPage = false;

    //是否有前一页
    private boolean hasPreviousPage = false;

    //是否有下一页
    private boolean hasNextPage = false;
    public void setPageNum(Integer pageNum){
        /* 数据边界的有效检查 */
        if (pageNum < 1) {
            pageNum = 1;
        }
        if (pageNum > total) {
            pageNum = total;
        }

        this.pageNum = pageNum;
    }
}
