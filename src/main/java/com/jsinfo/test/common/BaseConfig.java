package com.jsinfo.test.common;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jsinfo.test.controller.TestController;
import com.jsinfo.test.model.User;

/**
 * Created by Administrator on 2016/11/14.
 */
public class BaseConfig extends JFinalConfig{
    public void configConstant(Constants me) {
        me.setDevMode(true);
        me.setViewType(ViewType.FREE_MARKER);
    }

    public void configRoute(Routes me) {
        me.add("/",TestController.class,"/test");
    }

    public void configPlugin(Plugins me) {
        loadPropertyFile("config.txt");
        C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
        me.add(c3p0Plugin);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        me.add(arp);
        arp.addMapping("user", "id", User.class);
    }

    public void configInterceptor(Interceptors me) {

    }

    public void configHandler(Handlers me) {
        me.add(new MyHandler());
    }

//    public static void main(String[] args) {
//        JFinal.start("src/main/webapp", 80, "/", 5);
//
//    }
}
