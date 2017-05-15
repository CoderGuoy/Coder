package com.coder.guoy.recyclerview.designpattern.strategy;

/**
 * @Version:
 * @Author:
 * @CreateTime:2017年5月15日
 * @Descrpiton:
 */
public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.print("橡皮鸭吱吱叫\n");
    }
}
