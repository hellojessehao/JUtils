JUtils项目介绍

本项目运行环境为华为鸿蒙系统，项目旨在让从安卓转移到鸿蒙的开发者能够在使用一些基础API时获得安卓开发的体验，
如页面跳转、弹吐司、打印日志时等。<br>
项目依赖：<br>
1.在工程根目录下build.gradle相应位置加入如下代码：<br>
	allprojects {<br>
		repositories {<br>
			...<br>
			maven { url 'https://jitpack.io' }<br>
		}<br>	
	}<br>
2.在需要依赖该项目的模块下的build.gradle相应位置加入如下代码：<br>
	dependencies {<br>
		implementation 'com.github.hellojessehao:JUtils:Tag'<br>
	}<br>
<br>
使用问题中遇到问题或有好的建议欢迎给我的csdn博客发私信。<br>
csdn首页：https://blog.csdn.net/yonghuming_jesse
