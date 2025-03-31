package app.kaidonav.downloader;

import androidx.annotation.Nullable;

import app.kaidonav.util.Utils;

class ExpandRetryConfirmationListener implements Runnable
{
  @Nullable
  private final Utils.Proc<Boolean> mDialogClickListener;

  ExpandRetryConfirmationListener(@Nullable Utils.Proc<Boolean> dialogClickListener)
  {
    mDialogClickListener = dialogClickListener;
  }

  @Override
  public void run()
  {
    if (mDialogClickListener == null)
      return;
    mDialogClickListener.invoke(true);
  }
}
