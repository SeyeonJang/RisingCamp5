package com.example.risingcamp5

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import com.example.risingcamp5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // binding
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnvMain.itemIconTintList = null

        // bnv-fragment 연결
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    changeFragment(HomeFragment())
                }
                R.id.town -> {
                    changeFragment(TownFragment())
                }
                R.id.place -> {
                    changeFragment(PlaceFragment())
                }
                R.id.chat -> {
                    changeFragment(ChatFragment())
                }
                R.id.my -> {
                    changeFragment(MyFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        binding.bnvMain.selectedItemId = R.id.home

    }

    // bnv - fragment 바꾸기
    // 밑에 replace에서 불러온 fragments는 ListView임
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragments, fragment)
            .commit()
    }
}