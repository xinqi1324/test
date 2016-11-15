package com.jsinfo.test.common;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/11/14.
 */
public class MyHandler extends Handler {
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        String proname = request.getContextPath();
        request.setAttribute("proname",proname);
        next.handle(target, request, response, isHandled);
    }
}
