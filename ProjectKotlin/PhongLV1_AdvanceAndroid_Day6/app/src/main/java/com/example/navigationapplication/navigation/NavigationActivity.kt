package com.example.navigationapplication.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigationapplication.R
import com.example.navigationapplication.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}