package com.xuyijie.mangoschool;



import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.xuyijie.module_home.HomeFragment;
import com.xuyijie.module_lib.base.BaseActivity;
import com.xuyijie.module_lib.contract.EmptyContract;
import com.xuyijie.module_lib.presenter.EmptyPresenter;
import com.xuyijie.module_lib.weight.MyDialog;
import com.xuyijie.module_message.MessageFragment;
import com.xuyijie.module_shop.ShopFragment;
import com.xuyijie.module_user.UserFragment;

public class MainActivity extends BaseActivity<EmptyContract.View, EmptyPresenter> implements View.OnClickListener {

    private RadioGroup bottomBar;

    private MyDialog myDialog1;
    private ImageView index_bottom_bar_scan;
    private FragmentManager supportFragmentManager;
    Fragment homeFragment;
    Fragment messageFragment;
    Fragment shopFragment;
    Fragment userFragment;


    @Override
    public boolean isSetStatusBarTranslucent() {
        return true;
    }

    @Override
    public EmptyPresenter getPresenter() {
        return null;
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        index_bottom_bar_scan = findViewById(R.id.index_bottom_bar_scan);
        index_bottom_bar_scan.setOnClickListener(this);
        bottomBar = findViewById(R.id.bottomBar);
        supportFragmentManager = getSupportFragmentManager();

        bottomBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                final FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                hideAllFragment(transaction);
                switch (checkedId) {
                    case R.id.rb_home:
                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                            transaction.add(R.id.flContainer, homeFragment);
                        } else {
                            transaction.show(homeFragment);
                        }
                        break;
                    case R.id.rb_resource:
                        if (shopFragment == null) {
                            shopFragment = new ShopFragment();
                            transaction.add(R.id.flContainer, shopFragment);
                        } else {
                            transaction.show(shopFragment);
                        }
                        break;
                    case R.id.rb_chat:
                        if (messageFragment == null) {
                            messageFragment = new MessageFragment();
                            transaction.add(R.id.flContainer, messageFragment);
                        } else {
                            transaction.show(messageFragment);
                        }
                        break;
                    case R.id.rb_user:
                        if (userFragment == null) {
                            userFragment = new UserFragment();
                            transaction.add(R.id.flContainer, userFragment);
                        } else {
                            transaction.show(userFragment);
                        }
                        break;
                }
                transaction.commit();
            }
        });
        showFirstPosition();
    }
    private void showFirstPosition() {
        supportFragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.flContainer, homeFragment);
        transaction.commit();
    }

    public void hideAllFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (shopFragment != null) {
            transaction.hide(shopFragment);
        }
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (userFragment != null) {
            transaction.hide(userFragment);
        }
    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {

    }
}
