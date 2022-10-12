package com.furkansenol.localsqlitelearnproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val veritabani = this.openOrCreateDatabase("DB", Context.MODE_PRIVATE,null)
            veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (urun_Id INTEGER PRIMARY KEY, urun_Ad VARCHAR, urun_Fiyat INT)")
            //veritabani.execSQL("INSERT INTO urunler(urun_Ad,urun_Fiyat) VALUES ('Ayakkabi',100)")

            val cursor = veritabani.rawQuery("SELECT * FROM urunler",null)
            val getIdColumnIndex=cursor.getColumnIndex("urun_Id")
            val getAdColumnIndex=cursor.getColumnIndex("urun_Ad")
            val getFiyatColumnIndex=cursor.getColumnIndex("urun_Fiyat")

            while (cursor.moveToNext()){
                println(cursor.getInt(getIdColumnIndex))
                println(cursor.getString(getAdColumnIndex))
                println(cursor.getInt(getFiyatColumnIndex))
            }
            cursor.close()

        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}