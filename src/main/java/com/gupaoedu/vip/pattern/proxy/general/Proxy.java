package com.gupaoedu.vip.pattern.proxy.general;

import com.sun.org.apache.bcel.internal.generic.ISUB;

/**
 * @author Created by huawd
 * @date 2020/9/29
 */
public class Proxy implements ISubject{

    private ISubject iSubject;

    public Proxy(ISubject iSubject) {
        this.iSubject = iSubject;
    }

    public void request() {
       before();
       System.out.println("real service called!!!!");
       after();
    }
    public static void before(){
        System.out.println("called before");
    }
    public static void after(){
        System.out.println("called after");
    }
}
