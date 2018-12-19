package me.tabacowang.mvvmarch.ui

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import me.tabacowang.mvvmarch.R

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}