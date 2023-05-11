package com.example.commonui.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.commonui.activities.adapter.SliderAdapter
import com.example.commonui.databinding.ActivitySliderBinding
import java.util.Timer
import java.util.TimerTask


class SliderActivity : AppCompatActivity() {

    private var startSlider = true

    private var sliderCurrentPage = 0
    private var sliderList: ArrayList<String> = ArrayList()
    private lateinit var sliderAdapter : SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySliderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            sliderList.addAll(arrayListOf("","","",""))

            sliderAdapter =  SliderAdapter(sliderList, this@SliderActivity)

            vpHomeSlider.adapter = sliderAdapter
            indicator.setupWithViewPager(vpHomeSlider, true)

            val handler = Handler(Looper.getMainLooper())
            val update = Runnable {
                if (sliderCurrentPage == sliderList.size) {
                    sliderCurrentPage = 0
                }
                vpHomeSlider.setCurrentItem(sliderCurrentPage++, true)
            }

            Timer().schedule(object : TimerTask() {
                override fun run() {
                    if (startSlider){
                        handler.post(update)
                    }
                }
            }, 2800, 2800)

            vpHomeSlider.addOnPageChangeListener(object : OnPageChangeListener {
                override fun onPageSelected(position: Int) {
                    sliderCurrentPage = position
                }
                override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {}
                override fun onPageScrollStateChanged(pos: Int) {}
            })

        }

    }

}