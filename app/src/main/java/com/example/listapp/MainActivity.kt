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

        val zero = 5
        val one = 1
        val two = 2
        val three = 3
        val four = 4
        val five = 5
        val six =6
        val seven =7
        val esit = 6
        val soafj = 9

        binding.textView.text = "Edited This"
        binding.textView.text = "Edited This"
        binding.textView.text = "Edited This"
        binding.textView.text = "Edited This"
        binding.textView.text = "Edited This"
        binding.textView.text = "Edited This"
        binding.textView.text = "Edited This"
        binding.textView.text = "Edited This"

        binding.textView.text = "And This"
    }
}