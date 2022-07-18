package com.example.listapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = "Hello There"

        binding.textView.text = "Edited This"

        binding.textView.text = "And This here"

    }
}