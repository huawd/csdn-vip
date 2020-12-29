package com.gupaoedu.vip.pattern.singleton.test;

import com.gupaoedu.vip.pattern.singleton.lazy.LazyStaticInnerClassSingleton;

import java.lang.reflect.Constructor;

/**
 * @author Created by huawd
 * @date 2020/12/17
 */
public class ReflectionSingletonTest {
    public static void main(String[] args) {
        LazyStaticInnerClassSingleton instanceOne = LazyStaticInnerClassSingleton.getInstance() ;
        LazyStaticInnerClassSingleton instanceTwo = null;
        try {
            Constructor[] constructors = LazyStaticInnerClassSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (LazyStaticInnerClassSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}
