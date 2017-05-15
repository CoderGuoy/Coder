package com.coder.guoy.recyclerview.designpattern.strategy;

/**
 * @Version:
 * @Author:
 * @CreateTime:2017年5月15日
 * @Descrpiton:
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        mFlyBehavior = new FlyNoWay();//一开始，我们的模型鸭是不会飞的
        mQuackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("我是模型鸭子\n");
    }
}
