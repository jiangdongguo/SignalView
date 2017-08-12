# SignalView
**自定义信号强度显示控件**

![image](http://www.baidu.com/img/bdlogo.gif)

**1. 添加依赖**
(1) 在工程build.gradle中添加
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
```
  
(2) 在module的gradle中添加
```
dependencies {
	   compile 'com.github.jiangdongguo:SignalView:v1.0'
}
```

**2. 使用方法**  

(1) Java中设置信号强度和信号类型  

```
设置信号强度
mSignalView.setSignalValue(5);
设置信号类型
mSignalView.setSignalTypeText("4G");
```

(2) XML文件配置
```
<com.jiangdg.singalviewlib.SignalView
        android:layout_width="60dp"
        android:layout_height="40dp"
        custom:signalTypeTextSize="8sp"
        custom:signalTypeTextColor="@color/colorBlack"/>

  <com.jiangdg.singalviewlib.SignalView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        custom:signalTypeTextSize="6sp"    // 信号类型文本字体大小
        custom:signalTypeTextColor="@color/colorBlack" // 信号类型文本字体颜色
        custom:signalCount="7"  // 信号柱数量
        custom:rectBorderWidth="2" // 信号柱边界宽度
        custom:signalRectInterval="4" // 信号柱之间间隔
        custom:rectBorderColor="@color/colorBlack" // 信号柱边界颜色
        custom:signalLowColor="@color/colorRed" // 弱信号颜色
        custom:signalMiddleColor="@color/colorYellow" // 中等强度信号颜色
        custom:signalHighColor="@color/colorGreen"/> // 强信号颜色
        ```  
	

 
