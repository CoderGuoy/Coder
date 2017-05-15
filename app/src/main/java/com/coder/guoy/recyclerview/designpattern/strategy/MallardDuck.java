package com.coder.guoy.recyclerview.designpattern.strategy;

/**
 * @Version:
 * @Author:
 * @CreateTime:
 * @Descrpiton:
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        mQuackBehavior = new Quack();
        mFlyBehavior = new FlyWithThings();
    }

    @Override
    public void display() {
        System.out.print("我是一只绿色鸭子\n");
    }
}
