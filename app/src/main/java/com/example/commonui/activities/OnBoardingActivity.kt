package com.example.commonui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.commonui.activities.adapter.ScreenSlidePagerAdapter
import com.example.commonui.databinding.ActivityWelcomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        with(binding) {
            val adapter = ScreenSlidePagerAdapter(this@OnBoardingActivity)
            binding.viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                //Some implementation
            }.attach()
        }
    }
}