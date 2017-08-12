# SignalView
自定义信号强度显示控件
![效果图](http://www.baidu.com/img/bdlogo.gif)

1. 添加依赖
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
