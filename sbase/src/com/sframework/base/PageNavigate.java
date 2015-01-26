package com.sframework.base;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * 页面导航
 * User: 孙伟力
 * Date: 15/1/26
 * Time: 下午7:35
 */
public final class PageNavigate {
    private FragmentActivity activity;
    private PageStack pageStack = new PageStack();
    public static PageNavigate pageNavigate = new PageNavigate();

    private PageNavigate() {
    }

    public static PageNavigate getInstance() {
        return pageNavigate;
    }

    public void init(FragmentActivity act) {
        this.activity = act;
    }

    public void back() {
        if (pageStack.isEmpty()) {
            return;
        }
        BasePage page = pageStack.pop();
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame_content, page);
        transaction.commit();
    }
    public void navigate(Class<BasePage> pageClass) {
        if (activity == null) {
            throw new UnsupportedOperationException("请先初始化");
        }
        BasePage page = null;
        try {
            page = pageClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame_content, page);
        pageStack.add(page);
        transaction.commit();
    }

    public int getStackLength() {
        int length = 0;
        length = pageStack.pageSize();
        return length;
    }
}
