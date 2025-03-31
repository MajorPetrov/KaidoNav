#include "app/kaidonav/Framework.hpp"
#include "app/kaidonav/core/jni_helper.hpp"

#include "search/displayed_categories.hpp"

extern "C"
{
JNIEXPORT jobjectArray JNICALL Java_app_kaidonav_sdk_search_DisplayedCategories_nativeGetKeys(JNIEnv * env, jclass)
{
  ::Framework * fr = g_framework->NativeFramework();
  ASSERT(fr, ());
  search::DisplayedCategories categories = fr->GetDisplayedCategories();
  return jni::ToJavaStringArray(env, categories.GetKeys());
}
}  // extern "C"
