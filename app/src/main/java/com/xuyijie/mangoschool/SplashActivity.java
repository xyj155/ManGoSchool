package com.xuyijie.mangoschool;


import com.xuyijie.module_lib.base.BaseActivity;
import com.xuyijie.module_lib.contract.EmptyContract;
import com.xuyijie.module_lib.presenter.EmptyPresenter;

public class SplashActivity extends BaseActivity<EmptyContract.View, EmptyPresenter> {



    @Override
    public boolean isSetStatusBarTranslucent() {
        return false;
    }

    @Override
    public EmptyPresenter getPresenter() {
        return null;
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
