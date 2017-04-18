# RecyclerView

> MVVM开发模式中RecyclerView使用SwipRefreshLayout实现下拉刷新，自定义上拉加载更多

## Screenshots
![](https://github.com/CoderGuoy/RecyclerView/tree/master/screenshots/recyclerview.gif)

### Version

#### V1.0.0（4-17）

 - 1.RecyclerView设置滑动监听，当前可见页面滑动到底部时(newState == RecyclerView.SCROLL_STATE_IDLE)，
 根据adapter返回的item类型显示foot（加载更多控件），此时去更新加载数据，如果有新数据，显示正常的item；
 如果没有新的数据，显示没有更多数据。具体见代码中的注释，比较详细

## LICENSE
    Copyright 2017 HugeTerry.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
