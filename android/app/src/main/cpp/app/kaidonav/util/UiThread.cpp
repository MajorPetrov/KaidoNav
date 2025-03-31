#include "app/kaidonav/core/jni_helper.hpp"
#include "app/kaidonav/platform/GuiThread.hpp"

extern "C"
{
// static void nativeProcessTask(long taskPointer);
JNIEXPORT void JNICALL
Java_app_kaidonav_util_concurrency_UiThread_nativeProcessTask(JNIEnv * env, jclass clazz, jlong taskPointer)
{
  android::GuiThread::ProcessTask(taskPointer);
}
}
