@echo off
"C:\\Users\\Aykut\\AppData\\Local\\Android\\Sdk\\cmake\\3.18.1\\bin\\cmake.exe" ^
  "-HC:\\Users\\Aykut\\AndroidStudioProjects\\ColorDetector\\opencv\\libcxx_helper" ^
  "-DCMAKE_SYSTEM_NAME=Android" ^
  "-DCMAKE_EXPORT_COMPILE_COMMANDS=ON" ^
  "-DCMAKE_SYSTEM_VERSION=29" ^
  "-DANDROID_PLATFORM=android-29" ^
  "-DANDROID_ABI=x86" ^
  "-DCMAKE_ANDROID_ARCH_ABI=x86" ^
  "-DANDROID_NDK=C:\\Users\\Aykut\\AppData\\Local\\Android\\Sdk\\ndk\\23.1.7779620" ^
  "-DCMAKE_ANDROID_NDK=C:\\Users\\Aykut\\AppData\\Local\\Android\\Sdk\\ndk\\23.1.7779620" ^
  "-DCMAKE_TOOLCHAIN_FILE=C:\\Users\\Aykut\\AppData\\Local\\Android\\Sdk\\ndk\\23.1.7779620\\build\\cmake\\android.toolchain.cmake" ^
  "-DCMAKE_MAKE_PROGRAM=C:\\Users\\Aykut\\AppData\\Local\\Android\\Sdk\\cmake\\3.18.1\\bin\\ninja.exe" ^
  "-DCMAKE_LIBRARY_OUTPUT_DIRECTORY=C:\\Users\\Aykut\\AndroidStudioProjects\\ColorDetector\\opencv\\build\\intermediates\\cxx\\RelWithDebInfo\\236d2y5n\\obj\\x86" ^
  "-DCMAKE_RUNTIME_OUTPUT_DIRECTORY=C:\\Users\\Aykut\\AndroidStudioProjects\\ColorDetector\\opencv\\build\\intermediates\\cxx\\RelWithDebInfo\\236d2y5n\\obj\\x86" ^
  "-DCMAKE_BUILD_TYPE=RelWithDebInfo" ^
  "-BC:\\Users\\Aykut\\AndroidStudioProjects\\ColorDetector\\opencv\\.cxx\\RelWithDebInfo\\236d2y5n\\x86" ^
  -GNinja ^
  "-DANDROID_STL=c++_shared"
