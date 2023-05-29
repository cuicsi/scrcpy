package top.saymzx.scrcpy_android

class Device(
  val name: String,
  val address: String,
  val port: Int,
  val videoCodec: String,
  val maxSize: Int,
  val fps: Int,
  val videoBit: Int,
  val setResolution:Boolean,
  val defaultFull:Boolean
){
  var isFull=defaultFull
  // -10为停止状态，-1~-9为停止中，0为准备中，1为已连接ADB，2为已连接音视频，3为投屏中
  var status=-10
}