package cn.wang.utils;

import java.util.List;

public class PageBean {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalCount;
    private Integer totalPage;
    private List list;

    public PageBean(Integer currentPage, Integer pageSize, Integer totalCount) {
//        通过数据库查询
        this.totalCount = totalCount;


        this.currentPage = currentPage;
        this.pageSize = pageSize;

        this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
    }

    //封装计算索引的方法
    public Integer getStart() {
        return (this.currentPage - 1) * this.pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
