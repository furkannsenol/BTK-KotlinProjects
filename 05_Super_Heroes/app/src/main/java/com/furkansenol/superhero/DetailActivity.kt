package com.furkansenol.superhero

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        val superHeroNameInfo = intent.getStringExtra("superHeroNameInfo")
        detail_Name.text = superHeroNameInfo

        val superHeroPicInfo = intent.getIntExtra("superHeroPicInfo",0)
        val bitmap=BitmapFactory.decodeResource(applicationContext.resources,superHeroPicInfo)
        detail_Image.setImageBitmap(bitmap)

        /*val superHeroPictureInfo = SingletonClass.SelectedHero
        detail_Image.setImageBitmap(superHeroPictureInfo.heroImage)*/
    }
}