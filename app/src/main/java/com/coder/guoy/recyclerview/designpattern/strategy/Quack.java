package com.coder.guoy.recyclerview.designpattern.strategy;

/**
 * @Version:
 * @Author:
 * @CreateTime:2017年5月15日
 * @Descrpiton:真正会叫的鸭子
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.print("鸭子呱呱叫\n");
    }
}
