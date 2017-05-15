package com.coder.guoy.recyclerview.designpattern;

import android.os.Bundle;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityStrategyDesignBinding;
import com.coder.guoy.recyclerview.designpattern.strategy.Duck;
import com.coder.guoy.recyclerview.designpattern.strategy.FlyRocketPowered;
import com.coder.guoy.recyclerview.designpattern.strategy.MallardDuck;
import com.coder.guoy.recyclerview.designpattern.strategy.ModelDuck;

public class StrategyDesign extends MvvmBaseActivity<ActivityStrategyDesignBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_design);
        showContentView();
        Duck duck = new MallardDuck();
        duck.performQuack();
        duck.performFly();

        Duck modle = new ModelDuck();
        modle.performFly();
        modle.setFlyBehavior(new FlyRocketPowered());
        modle.performFly();
    }
}
