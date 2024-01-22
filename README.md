# LittleTools
ScanAPKPermis 用来提取APK所有用到的权限，后续应该会发展成合规测试工具，加入不符合项检测模块
- 单个APK扫描，需要指定APK文件 `java -jar ScanPermis.jar exmaple.apk`
- 批量扫描，需要指定APK所在文件夹 `java -jar ScanPermis.jar -f /folder_exmaple/`
```bash
File from extraction D:\1-JavaStudy\calcTest\Example.apk
Folder: Example
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
```
