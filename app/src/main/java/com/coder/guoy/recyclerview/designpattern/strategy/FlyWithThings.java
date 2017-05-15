package com.coder.guoy.recyclerview.designpattern.strategy;

/**
 * @Version:
 * @Author:
 * @CreateTime:
 * @Descrpiton:真正会飞的
 */
public class FlyWithThings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.print("I can Fly!\n");
    }
}
