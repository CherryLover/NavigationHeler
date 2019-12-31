# NavigationHelper

## 概述

NavigationHelper 是一个用于辅助使用 Navigation 的开源库。内置利用 Navigation 做到保存状态切换 Fragment 的效果。

## 如何使用

[![](https://jitpack.io/v/CherryLover/NavigationHeler.svg)](https://jitpack.io/#CherryLover/NavigationHeler)

在你的项目的根基目录的 build.gradle 中 repositories 的末尾配置：

```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Step 2. 添加依赖

```groovy
dependencies {
  implementation 'com.github.CherryLover:NavigationHeler:Tag'
}
```

### 使用

1. 在 Navigation Graph 中使用 keep_state_fragment 替换 Fragment。

```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto" android:id="@+id/demo_navigation"
    app:startDestination="@id/rootFragment">

    <keep_state_fragment
        android:id="@+id/rootFragment"
        android:name="me.monster.navigationhelper.fragment.RootFragment"
        android:label="RootFragment" >
        <action
            android:id="@+id/action_rootFragment_to_middleFragment"
            app:destination="@id/middleFragment"
            app:enterAnim="@anim/side_left_in"
            app:exitAnim="@anim/side_left_out"
            app:popEnterAnim="@anim/side_right_in"
            app:popExitAnim="@anim/side_right_out" />
    </keep_state_fragment>
</navigation>
```

2. 在承载 Fragment 的 Activity 布局文件中的 fragment 节点移除 navGraph 属性，结果如下。

   ```
   <fragment
       android:id="@+id/fragment"
       android:name="androidx.navigation.fragment.NavHostFragment"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       app:defaultNavHost="true" />
   ```

3. 在 Fragment 承载的 Activity 中设置：

```kotlin
val navController = Navigation.findNavController(this, R.id.fragment)
val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment?
val navigator = KeepStateNavigator(this, navHostFragment!!.childFragmentManager, R.id.fragment)
navController.navigatorProvider.addNavigator(navigator)
navController.setGraph(R.navigation.demo_navigation)
```

### API

#### NavigationHelper

此类为提供工具方法的入口。

| 方法名     | 参数类型           | 返回值 | 作用           |
| ---------- | ------------------ | ------ | -------------- |
| navigateUp | View, Int          | void   | 返回指定的页面 |
| navigateUp | Activity, Int, Int | void   | 返回指定的页面 |
| close      | View, Int          | void   | 关闭指定的页面 |
| close      | Activity, Int, Int | void   | 关闭指定的页面 |
| navigateUp | View               | void   | 返回上一个页面 |
| navigateUp | Activity, Int      | void   | 返回上一个页面 |

