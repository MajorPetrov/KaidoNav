package app.kaidonav.location;

import android.content.Context;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import app.kaidonav.util.Config;
import app.kaidonav.util.log.Logger;

public class LocationProviderFactory
{
  private static final String TAG = LocationProviderFactory.class.getSimpleName();

  public static boolean isGoogleLocationAvailable(@NonNull Context context)
  {
    return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == ConnectionResult.SUCCESS;
  }

  public static BaseLocationProvider getProvider(@NonNull Context context, @NonNull BaseLocationProvider.Listener listener)
  {
    if (isGoogleLocationAvailable(context) && Config.useGoogleServices())
    {
      Logger.d(TAG, "Use google provider.");
      return new GoogleFusedLocationProvider(context, listener);
    }
    else
    {
      Logger.d(TAG, "Use native provider");
      return new AndroidNativeProvider(context, listener);
    }
  }
}
