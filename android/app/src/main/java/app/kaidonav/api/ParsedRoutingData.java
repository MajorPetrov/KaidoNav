package app.kaidonav.api;

import androidx.annotation.Keep;

import app.kaidonav.Framework;

/**
 * Represents Framework::ParsedRoutingData from core.
 */
// Used by JNI.
@Keep
@SuppressWarnings("unused")
public class ParsedRoutingData
{
  public final RoutePoint[] mPoints;
  @Framework.RouterType
  public final int mRouterType;

  public ParsedRoutingData(RoutePoint[] points, int routerType) {
    this.mPoints = points;
    this.mRouterType = routerType;
  }
}
