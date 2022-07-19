package com.example.listapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val game = bundle!!.getString("game")
        val position = bundle!!.getInt("position")

        binding.tvCharacterName.text = resources.getStringArray(R.array.dota2_hero_names)[position]
        binding.tvCharacterName.text = resources.getStringArray(R.array.dota2_short_description)[position]
        binding.tvCharacterName.text = resources.getStringArray(R.array.dota2_hero_names)[position]

    }
}