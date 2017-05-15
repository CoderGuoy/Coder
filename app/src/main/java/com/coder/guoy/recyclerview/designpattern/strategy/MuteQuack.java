package com.coder.guoy.recyclerview.designpattern.strategy;

/**
 * @Version:
 * @Author:
 * @CreateTime:2017年5月15日
 * @Descrpiton:不会叫的
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.print("不会叫\n");
    }
}
