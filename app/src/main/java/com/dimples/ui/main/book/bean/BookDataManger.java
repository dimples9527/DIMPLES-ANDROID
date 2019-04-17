package com.dimples.ui.main.book.bean;

import java.util.ArrayList;
import java.util.List;

public class BookDataManger {
    /**
     * 获取竖向数据
     *
     * @param len 数据条数
     * @return List<BookBean>
     */
    private static List<BookBean> getVerData(int len) {
        List<BookBean> bookBeans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            BookBean bookBean = new BookBean();
            bookBean.setShowImg(false);
            bookBean.setDesc("竖向数据" + i);
            bookBeans.add(bookBean);
        }
        return bookBeans;
    }

    /**
     * 获取横向数据
     *
     * @param len 数据条数
     * @return List<BookBean>
     */
    private static List<BookBean> getHorData(int len) {
        List<BookBean> bookBeans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            BookBean bookBean = new BookBean();
            bookBean.setShowImg(false);
            bookBean.setDesc("横向数据" + i);
            bookBeans.add(bookBean);
        }
        return bookBeans;
    }

    public static List<BookBean> getdData() {
        List<BookBean> data = new ArrayList<>(getVerData(5));
        BookBean bookBean1 = new BookBean();
        bookBean1.setData(getHorData(10));
        bookBean1.setItemType(BookBean.IBookItemType.HORIZONTAL);
        data.add(bookBean1);
        data.addAll(getVerData(6));
        BookBean bookBean2 = new BookBean();
        bookBean2.setData(getHorData(11));
        bookBean2.setItemType(BookBean.IBookItemType.HORIZONTAL);
        data.add(bookBean2);
        return data;
    }

}















