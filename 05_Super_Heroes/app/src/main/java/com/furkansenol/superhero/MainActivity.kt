package com.furkansenol.superhero

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var superHeroNames = ArrayList<String>()
        superHeroNames.add("Batman")
        superHeroNames.add("Superman")
        superHeroNames.add("Iron Man")
        superHeroNames.add("Aquaman")
        superHeroNames.add("Spiderman")

        //Verimsiz Tanımlama
        /*
        var superHeroPictures=ArrayList<Bitmap>()
        superHeroPictures.add(BitmapFactory.decodeResource(applicationContext.resources,R.drawable.batman))
        superHeroPictures.add(BitmapFactory.decodeResource(applicationContext.resources,R.drawable.superman))
        superHeroPictures.add(BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ironman))
        superHeroPictures.add(BitmapFactory.decodeResource(applicationContext.resources,R.drawable.aquaman))
        superHeroPictures.add(BitmapFactory.decodeResource(applicationContext.resources,R.drawable.spiderman))
        */

        var superHeroPictures = ArrayList<Int>()
        superHeroPictures.add(R.drawable.batman)
        superHeroPictures.add(R.drawable.superman)
        superHeroPictures.add(R.drawable.ironman)
        superHeroPictures.add(R.drawable.aquaman)
        superHeroPictures.add(R.drawable.spiderman)
        //adapter
        //RecyclerView in nasıl gorunecegi ayari
        val layoutManager =LinearLayoutManager(this)
        recyclerView_MainPage.layoutManager=layoutManager

        val adapter = RecyclerAdapter(superHeroNames,superHeroPictures)
        recyclerView_MainPage.adapter=adapter

    }
}