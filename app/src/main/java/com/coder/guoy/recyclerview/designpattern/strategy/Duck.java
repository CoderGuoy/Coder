package com.coder.guoy.recyclerview.designpattern.strategy;

/**
 * @Version:
 * @Author:
 * @CreateTime:
 * @Descrpiton:
 */
public abstract class Duck {
    FlyBehavior mFlyBehavior;
    QuackBehavior mQuackBehavior;

    public Duck(){

    }

    public abstract void display();

    public void performFly(){
        mFlyBehavior.fly();
    }

    public void performQuack(){
        mQuackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior fb) {
        mFlyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        mQuackBehavior = qb;
    }

    public void swim(){
        System.out.print("所有鸭子都会游泳");
    }
}
