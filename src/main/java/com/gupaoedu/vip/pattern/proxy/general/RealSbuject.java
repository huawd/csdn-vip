package com.gupaoedu.vip.pattern.proxy.general;

import sun.nio.cs.ext.ISCII91;

/**
 * @author Created by huawd
 * @date 2020/9/29
 */
public class RealSbuject implements  ISubject {

    public void request() {
        System.out.println("real service is called");
    }
}
