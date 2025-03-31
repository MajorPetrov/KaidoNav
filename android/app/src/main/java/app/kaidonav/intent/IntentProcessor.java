package app.kaidonav.intent;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import app.kaidonav.MwmActivity;

public interface IntentProcessor
{
  @Nullable
  boolean process(@NonNull Intent intent, @NonNull MwmActivity activity);
}
