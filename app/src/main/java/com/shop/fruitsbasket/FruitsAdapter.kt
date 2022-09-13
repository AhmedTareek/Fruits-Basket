package com.shop.fruitsbasket

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FruitsAdapter (private val fruits: List<Fruit>) : RecyclerView.Adapter<FruitsAdapter.FruitViewHolder>()
{
inner class FruitViewHolder(v : View) : RecyclerView.ViewHolder(v){
     var name: TextView
     var image:ImageView
    init {
        image = v.findViewById(R.id.fruit_image)
        name = v.findViewById(R.id.fruit_name_label)
        v.setOnClickListener{
            val currView = fruits[layoutPosition]
            Toast.makeText(v.context,currView.fruitName,Toast.LENGTH_SHORT).show()
            val intent = Intent(v.context,FruitDetailsActivity::class.java).apply {
                putExtra("Curr view",currView)
            }
            v.context.startActivity(intent)
        }
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val notUnderstood = LayoutInflater.from(parent.context).inflate(R.layout.fruit_card, parent, false)
        Log.d("follow", "onCreate called ")
        return FruitViewHolder(notUnderstood)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val currFruit = fruits[position]
        holder.name.text = " ${currFruit.fruitName}  ${currFruit.fruitPrice}$/Kilo."
        holder.image.setImageResource(currFruit.fruitImage)
        Log.d("follow", "onBind called on $position ")


    }

    override fun getItemCount(): Int {
        return fruits.size
    }


}