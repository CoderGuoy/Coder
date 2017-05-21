# Coder

> RecyclerView使用SwipRefreshLayout实现下拉刷新，自定义上拉加载更多

> RxJava+Retrofit请求网络数据,RecyclerView加载网络图片（图片加载框架Glide）

> RecyclerView为图片添加ObjectAnimator动画效果

> 继承ViewGroupon实现的 3D球

> Android 帧动画 视图动画 属性动画 [介绍及使用详情](http://blog.csdn.net/lengxuechiwu1314/article/details/71641004)

> 设计模式之策略模式 | Strategy Pattern [介绍及使用详情](http://blog.csdn.net/lengxuechiwu1314/article/details/72191041)

## Android Material Design

> Tablayout | 横向布局标签 [介绍及使用详情](http://blog.csdn.net/lengxuechiwu1314/article/details/71079546) 

> TextInputLayout | 文字输入布局 [介绍及使用详情](http://blog.csdn.net/lengxuechiwu1314/article/details/71107229) 

> FloatingActionButton | 悬浮按钮 [介绍及使用详情](http://blog.csdn.net/lengxuechiwu1314/article/details/71146380)

> Coordinatorlayout | 协调布局 [介绍及使用详情](http://blog.csdn.net/lengxuechiwu1314/article/details/71090247)

> Coordinatorlayout.Behavior | 自定义行为的协调布局 [介绍及使用详情](http://blog.csdn.net/lengxuechiwu1314/article/details/71090247)

> CoordinatorLayout APPBarLayout CollapsingTabLayout实现折叠头布局 Special thanks [CPUdream刘玉峰](http://blog.liuyufeng.tech/post/2017-04-19-toolbar.html)

> AppBarLayout | 嵌套布局 [介绍及使用详情](http://blog.csdn.net/lengxuechiwu1314/article/details/72472367)

> CollapsingToolbarLayout | 折叠工具布局 [介绍及使用详情](http://blog.csdn.net/lengxuechiwu1314/article/details/72602767)

> CardView | 卡片控件 [介绍及使用详情](http://blog.csdn.net/lengxuechiwu1314/article/details/71774554)

## Screenshots

![](https://github.com/CoderGuoy/Coder/blob/master/screenshots/coderguoy01.gif)![](https://github.com/CoderGuoy/Coder/blob/master/screenshots/coderguoy03.gif)![](https://github.com/CoderGuoy/Coder/blob/master/screenshots/coderguoy05.gif)![](https://github.com/CoderGuoy/Coder/blob/master/screenshots/3Dtagcloud.gif)![](https://github.com/CoderGuoy/Android-Material-Design/blob/master/screenshots/tablayout00.gif)![](https://github.com/CoderGuoy/Android-Material-Design/blob/master/screenshots/textinputlayout.gif)![](https://github.com/CoderGuoy/Coder/blob/master/screenshots/coordinator.gif)

### Version

#### V1.0.0（4-17）

 - 1.RecyclerView设置滑动监听，当前可见页面滑动到底部时(newState == RecyclerView.SCROLL_STATE_IDLE)，
 根据adapter返回的item类型显示foot（加载更多控件），此时去更新加载数据，如果有新数据，显示正常的item；
 如果没有新的数据，显示没有更多数据。具体见代码中的注释，比较详细

## LICENSE
 - 项目仅做学习交流，不用做商业用途，接口使用干货集中营的API
