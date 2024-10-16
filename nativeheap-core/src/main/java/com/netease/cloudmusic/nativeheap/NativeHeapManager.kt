package com.netease.cloudmusic.nativeheap

import android.util.Log
import androidx.annotation.Keep
import com.bytedance.shadowhook.ShadowHook

@Keep
object NativeHeapManager {
    private var hasInit = false
    const val TAG = "NativeHeapInc"

    init {
        ShadowHook.init(
            ShadowHook.ConfigBuilder()
                .setMode(ShadowHook.Mode.UNIQUE)
                .build()
        )

        hasInit = try {
            System.loadLibrary("nativeheap-core")
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
        Log.i(TAG, "init state is $hasInit")
    }

    fun init(){
        if (hasInit) {
            Log.i(TAG, "init")
            heapMemoryInc()
        }
    }

    private external fun heapMemoryInc()
}