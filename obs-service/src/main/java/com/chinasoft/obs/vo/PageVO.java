package com.chinasoft.obs.vo;

/**
 * Created by VerRan.Liu on 2017/9/28.
 */
public class PageVO {
    private Integer pageNum = 0;
    private Integer pageSize = 10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
