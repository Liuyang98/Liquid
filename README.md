# Liquid
一个处理网络状态反馈的框架，非侵入式，不必修改XML文件。用于显示“网络加载中”，“加载异常”，“无内容”等事务显示。提供全局和自定义两种风格选择。采用链式编程，建造者模式的风格。支持自定义事务界面

# 截图

![Alt text](https://github.com/Liuyang98/Liquid/blob/master/image/02.gif)

# 使用




# Api

初始化代码：
```
       //设置全局默认风格
      LiquidStyle.init()
                .setErrorIamge(R.mipmap.trans_fail)
                .setLoadImage(R.mipmap.trans_load)
                .setNoneImage(R.mipmap.trans_none)
                .setErrorText("网络加载异常")
                .setLoadText("加载中")
                .setNoneText("没有找到内容")
                .setTextColor(0xffdddddd)
                .setTextSize(20)
                .setClickLayoutRes(R.layout.layout_error)
                .setGifLayoutRes(R.layout.layout_loading);
                
```

具体用法：
```
       //显示默认风格的加载布局
        Liquid.showLoadingView(Activity activity);
        
        Liquid.showLoadingView(ViewGroup viewGrouop);
        
       //显示默认风格的异常布局
        Liquid.showErrorView(Activity activity);
        
        Liquid.showErrorView(ViewGroup viewGrouop);
        
       //显示默认风格的自定义事务布局
        Liquid.showCustomView(Activity activity);
        
        Liquid.showCustomView(ViewGroup viewGrouop);

        //创建独立风格的布局
        new Liquid.Builder()
                .setText(String text)
                .setImageRes(int imageRes)
                .setClickListener(View.OnClicklistener clickListener)
                .build(ViewGroup viewGroup) 
                .showErrorView();
        
        
        //清除Liquid框架所添加的布局
        Liquid.clear(Activity activity);
        
        Liquid.clear(ViewGroup viewGroup);

```
当传入对象是Activity类型时，会将视图添加到 android.R.id.content ，也就是通常setContent的控件下。
当传入对象是ViewGroup类型时，则会作为子View添加在ViewGroup控件中。推荐ViewGroup的具体类型为FrameLayout或者RelativeLayout，使用LinearLayout可能会造成框架无法显示事务布局

