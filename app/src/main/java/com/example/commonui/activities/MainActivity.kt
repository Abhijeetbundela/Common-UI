package com.example.commonui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.commonui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        with(binding) {
            playerBtn.setOnClickListener {
                startActivity(Intent(this@MainActivity, PlayerActivity::class.java))
            }
            onBoardingBtn.setOnClickListener {
                startActivity(Intent(this@MainActivity, OnBoardingActivity::class.java))
            }
            sliderBtn.setOnClickListener {
                startActivity(Intent(this@MainActivity, SliderActivity::class.java))
            }
        }

    }
}