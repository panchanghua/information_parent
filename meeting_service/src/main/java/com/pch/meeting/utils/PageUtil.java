package com.pch.meeting.utils;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.ToString;

import java.util.List;
/**
 * description: 自定义分页对象
 * @author: panchanghua
 * date: 2019-04-02 09:23
 **/
@ToString
@Data
public class PageUtil<T> {
    //当前页数
    private int pageNum;
    //页大小
    private int pageSize;
    //总页数
    private int totalSize;
    //数据集
    private List<T> list;

    public PageUtil(PageInfo<T> pageInfo) {
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.totalSize = pageInfo.getPages();
        this.list = pageInfo.getList();
    }

}
