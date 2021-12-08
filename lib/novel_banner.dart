import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class NovelBanner extends StatelessWidget {
  // 1为16:3 | 2为16:5 | 3为16:9
  final String size;

  const NovelBanner({Key key, this.size = "2"}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Platform.isAndroid ? AndroidView(
      viewType: "niuxiaoer.net/novel_banner",
      creationParamsCodec: const StandardMessageCodec(),
      creationParams: size
    ) : Container();
  }
}
