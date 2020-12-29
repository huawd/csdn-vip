package com.gupaoedu.vip.pattern.singleton.hungry;

/**
 * Created by Tom.
 */

/**
 * 优点：执行效率高，性能高，没有任何的锁
 * 缺点：某些情况下，可能会造成内存浪费
 */
public class HungrySingleton {

    //创建一个私有的实例
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    //声明一个无参构造
    private HungrySingleton(){}

    //返回实例对象方法
    public static HungrySingleton getInstance(){
        return  hungrySingleton;
    }
}
