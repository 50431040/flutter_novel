import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class NovelIcon extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Platform.isAndroid ? AndroidView(
      viewType: "niuxiaoer.net/novel_icon",
      creationParamsCodec: const StandardMessageCodec(),
    ) : Container();
  }
}
