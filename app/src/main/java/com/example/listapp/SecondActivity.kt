package com.example.listapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}