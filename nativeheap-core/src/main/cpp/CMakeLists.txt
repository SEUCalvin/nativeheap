# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html.
# For more examples on how to use CMake, see https://github.com/android/ndk-samples.

# Sets the minimum CMake version required for this project.
cmake_minimum_required(VERSION 3.18.1)

project("nativeheap-core")

add_library(
        nativeheap-core

        SHARED

        arthandler.c
)

find_package(shadowhook REQUIRED CONFIG)
target_link_libraries(nativeheap-core shadowhook::shadowhook)

find_library(
        log-lib

        log)

target_link_libraries(
        nativeheap-core

        ${log-lib})