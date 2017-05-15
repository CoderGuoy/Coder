package com.coder.guoy.recyclerview.designpattern.strategy;

/**
 * @Version:
 * @Author:
 * @CreateTime:2017年5月15日
 * @Descrpiton:不会飞的鸭子
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.print("I can't Fly!\n");
    }
}
