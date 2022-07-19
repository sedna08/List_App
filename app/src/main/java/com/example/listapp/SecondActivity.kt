package com.example.listapp

import android.content.res.TypedArray
import android.media.MediaPlayer
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

        if(game == "dota2") {
            binding.root.setBackgroundResource(R.drawable.dota2_background)
            binding.tvCharacterName.text = resources.getStringArray(R.array.dota2_hero_names)[position]
            binding.tvCharacterLore.text = resources.getStringArray(R.array.dota2_character_lore)[position]
            binding.tvAttributeDescription.text = resources.getStringArray(R.array.dota2_attributes)[position]
            binding.tvSmallDescription.text = resources.getStringArray(R.array.dota2_short_description)[position]
            binding.tvReference.text = resources.getStringArray(R.array.dota2_references)[position]
            val imgHero: TypedArray = resources.obtainTypedArray(R.array.dota2_img_heroes)
            val imgAttributeRole: TypedArray = resources.obtainTypedArray(R.array.dota2_img_attributes)
            val voiceline: TypedArray = resources.obtainTypedArray(R.array.dota2_voicelines)
            binding.ivHeroIcon.setImageDrawable(imgHero.getDrawable(position))
            binding.ivAttributeIcon.setImageDrawable(imgAttributeRole.getDrawable(position))
            val mediaPlayer = MediaPlayer.create(this, voiceline.getResourceId(position,position))
            mediaPlayer?.start()
        }
        else if(game == "lol") {
            binding.root.setBackgroundResource(R.drawable.lol_background)
            binding.tvCharacterName.text = resources.getStringArray(R.array.lol_champion_names)[position]
            binding.tvCharacterLore.text = resources.getStringArray(R.array.lol_character_lore)[position]
            binding.tvAttributeDescription.text = resources.getStringArray(R.array.lol_roles)[position]
            binding.tvSmallDescription.text = resources.getStringArray(R.array.lol_short_description)[position]
            binding.tvReference.text = resources.getStringArray(R.array.lol_references)[position]
            val imgChampion: TypedArray = resources.obtainTypedArray(R.array.lol_img_champions)
            val imgAttributeRole: TypedArray = resources.obtainTypedArray(R.array.lol_img_attributes)
            val voiceline: TypedArray = resources.obtainTypedArray(R.array.lol_voicelines)
            binding.ivHeroIcon.setImageDrawable(imgChampion.getDrawable(position))
            binding.ivAttributeIcon.setImageDrawable(imgAttributeRole.getDrawable(position))
            val mediaPlayer = MediaPlayer.create(this, voiceline.getResourceId(position,position))
            mediaPlayer?.start()
        }


    }
}