cmake_minimum_required(VERSION 3.22.1)

project(kaidonav C CXX)

set(SRC
  # JNI headers
  ../../../../../private.h
        app/kaidonav/core/jni_helper.hpp
        app/kaidonav/core/jni_java_methods.hpp
        app/kaidonav/core/logging.hpp
        app/kaidonav/core/ScopedEnv.hpp
        app/kaidonav/core/ScopedLocalRef.hpp
        app/kaidonav/Framework.hpp
        app/kaidonav/opengl/android_gl_utils.hpp
        app/kaidonav/opengl/androidoglcontext.hpp
        app/kaidonav/opengl/androidoglcontextfactory.hpp
        app/kaidonav/opengl/gl3stub.h
        app/kaidonav/platform/GuiThread.hpp
        app/kaidonav/platform/AndroidPlatform.hpp
        app/kaidonav/util/Distance.hpp
        app/kaidonav/util/FeatureIdBuilder.hpp
        app/kaidonav/vulkan/android_vulkan_context_factory.hpp

  # JNI sources
        app/kaidonav/sdk/search/DisplayedCategories.cpp
        app/kaidonav/sdk/search/SearchEngine.cpp
        app/kaidonav/sdk/search/SearchRecents.cpp
        app/kaidonav/core/jni_helper.cpp
        app/kaidonav/core/jni_java_methods.cpp
        app/kaidonav/core/logging.cpp
        app/kaidonav/bookmarks/data/BookmarkManager.cpp
        app/kaidonav/DownloadResourcesLegacyActivity.cpp
        app/kaidonav/editor/Editor.cpp
        app/kaidonav/editor/OpeningHours.cpp
        app/kaidonav/editor/OsmOAuth.cpp
        app/kaidonav/Framework.cpp
        app/kaidonav/isolines/IsolinesManager.cpp
        app/kaidonav/LocationState.cpp
        app/kaidonav/Map.cpp
        app/kaidonav/MapManager.cpp
        app/kaidonav/MwmApplication.cpp
        app/kaidonav/routing/RoutingOptions.cpp
        app/kaidonav/settings/UnitLocale.cpp
        app/kaidonav/settings/MapLanguageCode.cpp
        app/kaidonav/sound/tts.cpp
        app/kaidonav/subway/SubwayManager.cpp
        app/kaidonav/TrackRecorder.cpp
        app/kaidonav/TrafficState.cpp
        app/kaidonav/UserMarkHelper.cpp
        app/kaidonav/opengl/android_gl_utils.cpp
        app/kaidonav/opengl/androidoglcontext.cpp
        app/kaidonav/opengl/androidoglcontextfactory.cpp
        app/kaidonav/opengl/gl3stub.cpp
        app/kaidonav/platform/GuiThread.cpp
        app/kaidonav/platform/HttpThread.cpp
        app/kaidonav/platform/Language.cpp
        app/kaidonav/platform/Localization.cpp
        app/kaidonav/platform/AndroidPlatform.cpp
        app/kaidonav/platform/PThreadImpl.cpp
        app/kaidonav/platform/SecureStorage.cpp
        app/kaidonav/platform/SocketImpl.cpp
        app/kaidonav/util/Config.cpp
        app/kaidonav/util/GeoUtils.cpp
        app/kaidonav/util/HttpClient.cpp
        app/kaidonav/util/Language.cpp
        app/kaidonav/util/LogsManager.cpp
        app/kaidonav/util/NetworkPolicy.cpp
        app/kaidonav/util/StringUtils.cpp
        app/kaidonav/util/UiThread.cpp
        app/kaidonav/vulkan/android_vulkan_context_factory.cpp
)

omim_add_library(${PROJECT_NAME} SHARED ${SRC})

target_include_directories(${PROJECT_NAME} PRIVATE .)

target_link_libraries(${PROJECT_NAME}
  # Kaido Nav libs
  map
  # ge0
  # tracking
  # routing
  # traffic
  # routing_common
  # drape_frontend
  # shaders
  # search
  # storage
  # descriptions
  # drape
  # kml
  # editor
  # transit
  # indexer
  # platform
  # mwm_diff
  # bsdiff
  # geometry
  # coding
  # base
  # opening_hours
  # pugixml
  # expat
  # freetype
  # minizip
  # cppjansson
  # protobuf
  # succinct
  # stb_image
  # icu
  # agg
  # vulkan_wrapper

  # Android libs
  log
  android
  EGL
  GLESv2
  atomic
  z
)

#target_link_options(${PROJECT_NAME} PRIVATE "-fuse-ld=gold")
