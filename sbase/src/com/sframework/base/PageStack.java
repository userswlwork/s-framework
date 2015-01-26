package com.sframework.base;

import java.util.Stack;

/**
 * User: 孙伟力
 * Date: 15/1/26
 * Time: 下午7:07
 */
public class PageStack {
    public Stack<BasePage> stack = new Stack<BasePage>();

    public void add(BasePage basePage) {
        stack.add(basePage);
    }

    public int pageSize() {
        return stack.size();
    }

    public BasePage pop() {
        return stack.pop();
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }
}
