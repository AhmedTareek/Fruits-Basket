package com.shop.fruitsbasket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FruitDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_details)
        val txt = findViewById<TextView>(R.id.fruit_description_name)
        val img = findViewById<ImageView>(R.id.image_in_description)
        val des = findViewById<TextView>(R.id.detailed_description)
        val data = intent.getParcelableExtra<Fruit>("Curr view")
        txt.text = data?.fruitName
        if(data?.fruitImage != null) {
            img.setImageResource(data.fruitImage)
        }
        des.text = data?.details

    }
}