# LittleTools
ScanAPKPermis 用来提取APK所有用到的权限，后续应该会发展成合规测试工具，加入不符合项检测模块
- 单个APK扫描，需要指定APK文件 `java -jar ScanPermis.jar exmaple.apk`
- 批量扫描，需要指定APK所在文件夹 `java -jar ScanPermis.jar -f /folder_exmaple/`
```bash

   _____                      _ _                         _____                    __                      _____  _____  
  / ____|                    | (_)                       / ____|                  / _|               /\   |  __ \|  __ \ 
 | |     ___  _ __ ___  _ __ | |_  __ _ _ __   ___ ___  | (___   ___ __ _ _ __   | |_ ___  _ __     /  \  | |__) | |__) |
 | |    / _ \| '_ ` _ \| '_ \| | |/ _` | '_ \ / __/ _ \  \___ \ / __/ _` | '_ \  |  _/ _ \| '__|   / /\ \ |  ___/|  ___/ 
 | |___| (_) | | | | | | |_) | | | (_| | | | | (_|  __/  ____) | (_| (_| | | | | | || (_) | |     / ____ \| |    | |     
  \_____\___/|_| |_| |_| .__/|_|_|\__,_|_| |_|\___\___| |_____/ \___\__,_|_| |_| |_| \___/|_|    /_/    \_\_|    |_|     
                       | |                                                                                               
                       |_|                                                                                               
This version(0.1) is only used to extract all permission attributes of APK. Author: novy, Github: https://github.com/novysodope/LittleTools


Analyzing APK: D:\1-JavaStudy\calcTest\example.apk
Folder: example
| Permissions List                         |
|------------------------------------------|
| android.permission.INTERNET              |
| android.permission.ACCESS_NETWORK_STATE  |
| android.permission.WRITE_EXTERNAL_STORAGE |
| android.permission.READ_EXTERNAL_STORAGE |
| android.permission.MANAGE_EXTERNAL_STORAGE |
| android.permission.ACCESS_COARSE_LOCATION |
| android.permission.ACCESS_FINE_LOCATION  |
| android.permission.READ_MEDIA_IMAGES     |
| android.permission.READ_MEDIA_AUDIO      |
| android.permission.READ_MEDIA_VIDEO      |
| android.permission.CALL_PHONE            |
| android.permission.CAMERA                |
| android.permission.FLASHLIGHT            |
| android.permission.VIBRATE               |
| android.permission.POST_NOTIFICATIONS    |
| android.permission.WAKE_LOCK             |
| com.google.android.c2dm.permission.RECEIVE |
| com.example.intl.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION |
|------------------------------------------|

Analyzing APK: D:\1-JavaStudy\calcTest\example_test.apk
Folder: example_test
| Permissions List                         |
|------------------------------------------|
| android.permission.INTFERNET             |
| android.permission.ACCESS_WIFI_STATE     |
| android.permission.CAMERA                |
| android.permission.WRITE_EXTERNAL_STORAGE |
| android.permission.READ_EXTERNAL_STORAGE |
| android.permission.READ_CONTACTS         |
| android.permission.READ_MEDIA_IMAGES     |
| android.permission.READ_MEDIA_AUDIO      |
| android.permission.READ_MEDIA_VIDEO      |
| android.permission.CALL_PHONE            |
| android.permission.MANAGE_EXTERNAL_STORAGE |
| android.permission.BLUETOOTH             |
| android.permission.BLUETOOTH_ADMIN       |
| android.permission.BLUETOOTH_ADVERTISE   |
| android.permission.BLUETOOTH_CONNECT     |
| android.permission.BLUETOOTH_SCAN        |
| android.permission.ACCESS_COARSE_LOCATION |
| android.permission.ACCESS_FINE_LOCATION  |
| android.permission.REORDER_TASKS         |
| android.permission.INTERNET              |
| android.permission.ACCESS_NETWORK_STATE  |
| android.permission.READ_PHONE_STATE      |
| com.example_test.permission.JPUSH_MESSAGE |
| android.permission.POST_NOTIFICATIONS    |
| com.huawei.android.launcher.permission.CHANGE_BADGE |
| com.vivo.notification.permission.BADGE_ICON |
| com.hihonor.android.launcher.permission.CHANGE_BADGE |
| android.permission.VIBRATE               |
| android.permission.ACCESS_BACKGROUND_LOCATION |
| android.permission.QUERY_ALL_PACKAGES    |
| android.permission.GET_TASKS             |
| com.example_test.permission.PROCESS_PUSH_MSG |
| com.example_test.permission.PUSH_PROVIDER |
| com.example_test.permission.MIPUSH_RECEIVE |
| com.coloros.mcs.permission.RECIEVE_MCS_MESSAGE |
| com.heytap.mcs.permission.RECIEVE_MCS_MESSAGE |
|------------------------------------------|
```
