package app.kaidonav;

import androidx.annotation.Keep;

public interface MapRenderingListener
{
  default void onRenderingCreated() {}

  default void onRenderingRestored() {}

  // Called from JNI.
  @Keep
  @SuppressWarnings("unused")
  default void onRenderingInitializationFinished() {}
}
