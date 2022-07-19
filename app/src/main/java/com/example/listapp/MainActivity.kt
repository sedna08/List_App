package com.example.listapp

import android.app.Activity
import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.listapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dota 2 hero details (see strings.xml and images.xml)
        val heroChampionName1: Array<String> = resources.getStringArray(R.array.dota2_hero_names)
        val attributeRole1: Array<String> = resources.getStringArray(R.array.dota2_attributes)
        val shortDescription1: Array<String> = resources.getStringArray(R.array.dota2_short_description)
        val lore1: Array<String> = resources.getStringArray(R.array.dota2_character_lore)
        val reference1: Array<String> = resources.getStringArray(R.array.dota2_references)
        val imgAttributeRole1: TypedArray = resources.obtainTypedArray(R.array.dota2_img_attributes)
        val imgHeroChampion1: TypedArray = resources.obtainTypedArray(R.array.dota2_img_heroes)

        // Lol champion details (see strings.xml and images.xml)
        val heroChampionName2: Array<String> = resources.getStringArray(R.array.lol_champion_names)
        val attributeRole2: Array<String> = resources.getStringArray(R.array.lol_roles)
        val shortDescription2: Array<String> = resources.getStringArray(R.array.lol_short_description)
        val lore2: Array<String> = resources.getStringArray(R.array.lol_character_lore)
        val reference2: Array<String> = resources.getStringArray(R.array.lol_references)
        val imgAttributeRole2: TypedArray = resources.obtainTypedArray(R.array.lol_img_attributes)
        val imgHeroChampion2: TypedArray = resources.obtainTypedArray(R.array.lol_img_champions)

        // Create adapter for listview
        val heroListAdapter = ListAdapter(this, attributeRole1, heroChampionName1, shortDescription1, imgAttributeRole1, imgHeroChampion1)
        binding.lvHeroes.adapter = heroListAdapter
        val championListAdapter = ListAdapter(this, attributeRole2, heroChampionName2, shortDescription2, imgAttributeRole2, imgHeroChampion2)
        binding.lvChampions.adapter = championListAdapter

        // Set click listener
        binding.lvHeroes.setOnItemClickListener { adapterView, view, position, l ->
            heroChampionName1[position]
            Toast.makeText(this, heroChampionName1[position] + "\n" + attributeRole1[position], Toast.LENGTH_SHORT).show()
            // action to do if item is clicked
            val game = "dota2"
            val intent= Intent(this, SecondActivity::class.java)
            intent.putExtra("game", game)
            intent.putExtra("position", position)
            startActivity(intent)

        }

        binding.lvChampions.setOnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(this, heroChampionName2[position] + "\n" + attributeRole2[position], Toast.LENGTH_SHORT).show()
            // action to do if item is clicked
            val game = "lol"
            val intent= Intent(this, SecondActivity::class.java)
            intent.putExtra("game", game)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }
}

class ListAdapter (
    private val context: Activity,
    private val attributeRole: Array<String>,
    private val heroChampionName: Array<String>,
    private val shortDescription: Array<String>,
    private val imgAttributeRole: TypedArray,
    private val imgHeroChampion: TypedArray
) : ArrayAdapter<String>(context, R.layout.layout_listview, heroChampionName) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.layout_listview, null, true)

        val ivAttributeRole = rowView.findViewById<ImageView>(R.id.ivAttributeRole)
        val ivHeroChampionImage = rowView.findViewById<ImageView>(R.id.ivHeroChampionImage)
        val tvHeroChampionName = rowView.findViewById<TextView>(R.id.tvHeroChampionName)
        val tvAttributeRole = rowView.findViewById<TextView>(R.id.tvAttributeRole)
        val tvShortDescription = rowView.findViewById<TextView>(R.id.tvShortDescription)

        ivAttributeRole.setImageDrawable(imgAttributeRole.getDrawable(position))
        ivHeroChampionImage.setImageDrawable(imgHeroChampion.getDrawable(position))
        tvHeroChampionName.text = heroChampionName[position].uppercase()
        tvAttributeRole.text = attributeRole[position].uppercase()
        tvShortDescription.text = shortDescription[position].uppercase()

        return rowView
    }
}