package com.shop.fruitsbasket

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial

const val PREF_NAME = "com.shop.fruitsbasket"


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var switch:SwitchMaterial
    private lateinit var mySharedPreference:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switch = findViewById(R.id.switch_for_grid)
        recyclerView = findViewById(R.id.fruits_recycler_view)
        mySharedPreference = getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
        Log.d("cold", "main onCreate called ")

        if(mySharedPreference.getBoolean("switch_state",false)){
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
        else{
            recyclerView.layoutManager = GridLayoutManager(this,2)
            switch.isChecked = true
        }
        switch.setOnCheckedChangeListener { _, b ->
            setlayout(b)
        }
        recyclerView.adapter = FruitsAdapter(getListofFruits())

    }
    private fun getListofFruits() : List<Fruit>{
         val list = mutableListOf<Fruit>()
        list.add(Fruit("Mango",R.drawable.mango,10,"Mango is sweety"))
        list.add(Fruit("Grapes",R.drawable.grape,20,"grapes are small"))
        list.add(Fruit("Banana",R.drawable.banana,4,"banana color is yellow"))
        list.add(Fruit("Orange",R.drawable.orange,8,"Oranges are orange !!!"))
        list.add(Fruit("Apple",R.drawable.apple,18,"Who still uses Apple"))
        list.add(Fruit("Strawberry",R.drawable.farawla,20,"you know"))
        list.add(Fruit("Mix",R.drawable.collection,50,"a mix of everything all at once"))
        list.add(Fruit("Juice",R.drawable.juice,15,"Orange Juice"))
        list.add(Fruit("Lemon",R.drawable.lemon,20,"good for your health"))
        return list
    }

    fun setlayout(b: Boolean){
        if(b){
            recyclerView.layoutManager = GridLayoutManager(this,2)

        }else{
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
        mySharedPreference.edit{
            putBoolean("switch_state",!switch.isChecked)
            commit()
        }
    }



//    override fun onPause() {
//        super.onPause()
//        mySharedPreference.edit{
//            putBoolean("switch_state",switch.isChecked)
//            commit()
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        if(mySharedPreference.getBoolean("switch_state",false)){
//            recyclerView.layoutManager = GridLayoutManager(this,2)
//            switch.isChecked = true
//        }else{
//            recyclerView.layoutManager = LinearLayoutManager(this)
//        }
//    }
}

