# SignalView
**自定义信号强度显示控件**

![image](http://www.baidu.com/img/bdlogo.gif)

**1. 添加依赖**
(1) 在工程build.gradle中添加
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
(2) 在module的gradle中添加
dependencies {
	   compile 'com.github.jiangdongguo:SignalView:v1.0'
}

**2. 使用方法**

(1) XML文件配置
 <com.jiangdg.singalviewlib.SignalView
        android:layout_width="60dp"
        android:layout_height="40dp"
        custom:signalTypeTextSize="8sp"
        custom:signalTypeTextColor="@color/colorBlack"/>

  <com.jiangdg.singalviewlib.SignalView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        custom:signalTypeTextSize="6sp"    // 信号类型文本字体大小
        custom:signalTypeTextColor="@color/colorBlack"
        custom:signalCount="7"
        custom:rectBorderWidth="2"
        custom:signalRectInterval="4"
        custom:rectBorderColor="@color/colorBlack"
        custom:signalLowColor="@color/colorRed"
        custom:signalMiddleColor="@color/colorYellow"
        custom:signalHighColor="@color/colorGreen"/>
 
