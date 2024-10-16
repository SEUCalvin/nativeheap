package com.netease.cloudmusic.nativeheap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.netease.cloudmusic.nativeheap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val bigObject = ArrayList<LargeObjectTest>()
    private val normalObject = ArrayList<SmallObjectTest>()
    private var bigObjectClickTime = 0
    private var normalObjectClickTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.oomAlloc.setOnClickListener {
            bigObject.add(LargeObjectTest())
            bigObjectClickTime++
            binding.oomAlloc.text = "大对象分配了 $bigObjectClickTime 次"
        }

        binding.oomAllocSmall.setOnClickListener {
            normalObject.add(SmallObjectTest())
            normalObjectClickTime++
            binding.oomAllocSmall.text = "普通对象分配了 $normalObjectClickTime 次"
        }

        binding.nativeheap.setOnClickListener {
            NativeHeapManager.init()
        }
    }
}