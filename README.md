# scrcpy_android

## 说明

起因是我给我的妈妈买了一个便宜的平板，给她看电视剧，后来她想在平板上玩斗地主，因为平板屏幕大，看牌清楚，但是平板性能太差，所以我萌生了平板远程控制手机的想法，后来我尝试了市面上的安卓远程控制软件，比如NewDesk、RustDesk、甲壳虫、Uncon等等，但是均不理想，主要有以下缺点：

- 不支持音频传输
- 操作步骤繁琐（对我妈妈来说）
- 对旋转支持不太好（比如甲壳虫在旋转时容易黑屏）
- 需要root，部分如uncon要求root，洋垃圾平板无法root
- 对不同屏幕适配不好（平板和手机比例不同，如果强制全屏的话，会导致画面扁扁的，如果保持原比例，那么平板两侧会有很大的空余空间，浪费）
- 延迟较高，使用公网传输的控制软件延迟都很大

所以我决定自己实现一个投屏控制软件，主要就是利用了开源项目Scrcpy（在此感谢这个伟大的项目）

## 本软件特色

- 使用简单
- 得益于Scrcpy2.0集成了Sndcpy，支持了音频的传输（经测试游戏和音乐可以传输，通话不会流转）
- 自动修改被控端分辨率，最大化利用主控端屏幕
- 良好的旋转支持
- 自动检测被控端屏幕状态，熄屏后自动亮屏
- 超快启动
- 较低的延迟
- 支持小窗显示
- 支持多设备同时连接

## 使用步骤

1. 被控端打开无线ADB调试，端口为5555；
有root的用户可以在/data/adb/service.d/下新建adb.sh，并添加
``` shell
sleep 5 && setprop service.adb.tcp.port 5555 && stop adbd && start adbd
```
然后，为adb.sh添加可执行权限就可以，之后手机将开机自动启动ADB无线调试。
无root的用户，可在有线连接ADB后，在电脑端输入以下命令：
``` shell
adb tcpip 5555
```
2. 被控端安装scrcpy_back，将该软件放至桌面左半部分，将通知栏磁贴放至通知栏左半部分（放在左边是因为避免修改分辨率后显示界面超出屏幕点击不到，放在左边可保证总能在屏幕内显示），点击scrcpy_back或长按磁贴，并允许永久调试，测试软件是否正常工作（软件会自动退出，不是崩溃，可以手动修改分辨率，测试软件是否正常工作）
3. 被控端建议改为使用静态地址，可在手机上配置静态获取，也可以在路由器上配置静态分配
4. 主控端安装scrcpy_android，打开软件进行悬浮窗授权，添加设备，被控端同意永久调试，开始投屏


## 使用说明

### 默认选项

- 默认全屏显示，可以在添加设备时修改高级选项使用小窗模式
- 默认修改被控端分辨率，可以在添加设备时修改高级选项设置不修改
- 默认分辨率为720p，帧率为60帧，码率为8M，编解码器为H264

### 全屏模式

- 请注意设备全屏控制后无法不中断恢复为小窗
- 设备全屏控制后进入专注模式，如需退出投屏需按主控端电源键熄屏，也可以点按主控端通知栏消息
- 设备全屏控制后使用悬浮导航球导航，单击为返回、双击为桌面、长按为最近任务，悬浮球可拖动

### 小窗模式

- 小窗模式可以通过横条拖动，双机横条全屏控制
- 小窗模式点击右上角红点为关闭投屏，拖动右下角白点为更改小窗大小

### 其他

- 分辨率在退出后会自动恢复，如果非正常退出导致被控端未恢复，可使用scrcpy_back
- 投屏后声音会自动流转至主控端，音量大小受控于主控端，不需要调整被控端（除非被控端静音）

## 截图

<img src="https://github.com/mingzhixian/scrcpy/blob/master/pic/截屏/软件界面.png" width="200px"><img src="https://github.com/mingzhixian/scrcpy/blob/master/pic/截屏/添加设备.png" width="200px">
<img src="https://github.com/mingzhixian/scrcpy/blob/master/pic/截屏/小窗-竖屏.png" width="200px"><img src="https://github.com/mingzhixian/scrcpy/blob/master/pic/截屏/小窗-横屏.png" width="200px">
<img src="https://github.com/mingzhixian/scrcpy/blob/master/pic/截屏/多设备.png" width="200px">

## 鼓励

如果您觉得我的软件对您有帮助，可以赏俺一个硬币，万分感谢！

<img src="https://github.com/mingzhixian/scrcpy/blob/master/pic/截屏/微信.jpg" width="200px"><img src="https://github.com/mingzhixian/scrcpy/blob/master/pic/截屏/支付宝.jpg" width="200px">

## 反馈

<img src="https://github.com/mingzhixian/scrcpy/blob/master/pic/其他/反馈群.png" width="200px">