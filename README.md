# Liquid
一个处理网络状态反馈的框架，用于显示“网络加载中”，“加载异常”，“无内容”等事务显示。提供全局和自定义两种风格选择。采用链式编程，建造者模式的风格。支持自定义事务界面

# 截图

![Alt text](https://github.com/Liuyang98/Liquid/blob/master/image/02.gif)

#使用



#Api

初始化代码：
```
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
