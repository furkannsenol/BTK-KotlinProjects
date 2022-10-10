package com.furkansenol.fragmentproje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun frag1(view: View){
        val fragmenManager=supportFragmentManager
        val fragmentTransaction=fragmenManager.beginTransaction() //işlemi başlat

        //val firstFragment= FirstFragment()
        fragmentTransaction.replace(R.id.frameLayout_Main,FirstFragment()).commit()

    }

    fun frag2(view:View){
        val fragmenManager=supportFragmentManager
        val fragmentTransaction=fragmenManager.beginTransaction() //işlemi başlat

        //val secondFragment= SecondFragment()
        fragmentTransaction.replace(R.id.frameLayout_Main,SecondFragment()).commit()
    }

}