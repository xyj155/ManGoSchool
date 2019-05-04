package com.xuyijie.module_home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuyijie.module_lib.adapter.ViewPagerFragmentAdapter;
import com.xuyijie.module_lib.base.BaseFragment;
import com.xuyijie.module_lib.presenter.EmptyPresenter;
import com.xuyijie.module_lib.weight.ScaleTransitionPagerTitleView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator.MODE_EXACTLY;

public class HomeFragment extends BaseFragment<EmptyPresenter> {
    @BindView(R2.id.mg_home)
    MagicIndicator mgHome;
    @BindView(R2.id.vp_home)
    ViewPager vpHome;
    Unbinder unbinder;
    private String[] titles = {"推荐", "圈子", "关注"};
    private ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    public void initData() {

    }

    @Override
    public void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new CircleFragment());
        fragmentList.add(new ObserveFragment());
        viewPagerFragmentAdapter=new ViewPagerFragmentAdapter(getChildFragmentManager(),fragmentList);
        vpHome.setAdapter(viewPagerFragmentAdapter);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setText(titles[index]);
                simplePagerTitleView.setTextSize(28);//设置导航的文字大小
                simplePagerTitleView.setNormalColor(Color.GRAY);//正常状态下的标题颜色
                simplePagerTitleView.setSelectedColor(0xff000000);//选中的标题字体颜色
                TextPaint tp = simplePagerTitleView .getPaint();
                tp.setFakeBoldText(true);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vpHome.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setLineHeight(20);
                indicator.setLineWidth(80);
                indicator.setRoundRadius(20);
                indicator.setMode(MODE_EXACTLY);
                indicator.setColors(0xffffd100);
                return indicator;
            }
        });
        mgHome.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mgHome, vpHome);
    }

    @Override
    public int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public EmptyPresenter initPresenter() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
