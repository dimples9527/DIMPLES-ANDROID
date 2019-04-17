package com.dimples.ui.main.book.bean;

import java.util.List;

public class BookBean {

    private int itemType = IBookItemType.VERTICAL;

    private String Desc;

    private boolean showImg;

    private List<BookBean> data;

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public boolean isShowImg() {
        return showImg;
    }

    public void setShowImg(boolean showImg) {
        this.showImg = showImg;
    }

    public List<BookBean> getData() {
        return data;
    }

    public void setData(List<BookBean> data) {
        this.data = data;
    }

    public interface IBookItemType{
        int VERTICAL = 0;
        int HORIZONTAL = 1;
    }
}
