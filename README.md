# flutter_novel

穿山甲小说 Flutter SDK

## 一、引入
```yaml
dependencies:
  flutter_novel: lastVersion
```

## 二、拷贝配置文件

在内容输出->内容管理模块找到需要接入小说SDK的应用，点击"下载SDK参数配置"，然后将JSON配置文件拷贝到项目的assets文件夹下。具体请参考官方文档

## 三、使用

1. 初始化SDK

```dart
await FlutterNovel.init(appName: "", appVersionCode: 2, appVersionName: "", channel: "");
```

2. 打开独立的小说Activity

```dart
FlutterNovel.start();
```

3. 导流入口（目前只实现了Banner）

```dart
// size: 图片比例。1为16:3 | 2为16:5 | 3为16:9
// 无需设置点击事件，点击后默认会打开小说Acticuty
NovelBanner(size: "1")
```