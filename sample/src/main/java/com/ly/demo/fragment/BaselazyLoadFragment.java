package com.ly.demo.fragment;

/**
 * Created by yangl.liu on 2017/5/3.
 * 懒加载Fragment 基类
 */
public abstract class BaselazyLoadFragment extends BaseFragment {
    protected boolean isVisible;//是否可见
    protected boolean isPrepared;//是否初始化过
    protected boolean isInited;  //是否被加载过

    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    protected abstract void lazyLoad();

    /**
     * 是否跳过懒加载
     * false则进行
     */
    protected boolean checkLazy() {
        return !isPrepared || !isVisible || isInited;
    }

    /**
     * 可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * 不可见
     */
    protected void onInvisible() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        isVisible = getUserVisibleHint();
        if (isVisible) {
            onVisible();
        } else {
            onInvisible();
        }
    }
}