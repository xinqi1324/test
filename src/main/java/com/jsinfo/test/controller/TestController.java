package com.jsinfo.test.controller;

import com.jfinal.core.Controller;
import com.jsinfo.test.model.User;

/**
 * Created by Administrator on 2016/11/14.
 */
public class TestController extends Controller{

    public void index(){
//        User user = new User();
//        user.set("id",1);
//        user.set("name","xin");
//        user.set("gender",1);
//        user.save();
        User user1 = User.dao.findById(1);
        setAttr("user",user1);
        render("index.html");
    }
}
