package com.furkansenol.cook_book

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_food_detail.*
import java.io.ByteArrayOutputStream

class FoodDetailFragment : Fragment() {
    var secilenGorsel: Uri? = null
    var secilenBitmap: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_Save.setOnClickListener {
            save(it)
        }
        detail_Image.setOnClickListener {
            imageSave(it)
        }
        arguments?.let {
            var gelenBilgi = FoodDetailFragmentArgs.fromBundle(it).bilgi
            if (gelenBilgi.equals("menudengeldim")) {
                detail_Name.setText("")
                detail_Material.setText("")
                button_Save.visibility=View.VISIBLE

                val gorselSecmeArkaPlan=BitmapFactory.decodeResource(context?.resources,R.drawable.add_picture)
                detail_Image.setImageBitmap(gorselSecmeArkaPlan)


            } else {
                button_Save.visibility = View.INVISIBLE
                val  secilenId=FoodDetailFragmentArgs.fromBundle(it).id

                context?.let{
                    try {
                        val db= it.openOrCreateDatabase("FoodDB",Context.MODE_PRIVATE,null)
                        var cursor = db.rawQuery("SELECT * FROM tbl_Food WHERE food_Id = ?", arrayOf(secilenId.toString()))
                        val yemekIsmiIndex = cursor.getColumnIndex("food_Name")
                        val yemekImageIndex = cursor.getColumnIndex("food_Image")
                        val yemekMalzemeIndex = cursor.getColumnIndex("food_Material")

                        while (cursor.moveToNext()){
                            detail_Name.setText(cursor.getString(yemekIsmiIndex))
                            detail_Material.setText(cursor.getString(yemekMalzemeIndex))

                            val byteDizisi=cursor.getBlob(yemekImageIndex)
                            val bitmap=BitmapFactory.decodeByteArray(byteDizisi,0,byteDizisi.size)
                            detail_Image.setImageBitmap(bitmap )
                        }
                        cursor.close()
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }
        }

        super.onViewCreated(view, savedInstanceState)

    }

    private fun save(view: View) {
        //sqlite save
        val foodName = detail_Name.text.toString()
        val foodMaterial = detail_Material.text.toString()
        if (secilenBitmap != null) {
            val kucukBitmap = smallBitmapCreate(secilenBitmap!!, 300)
            //resmi veriye cevir
            val outputStream = ByteArrayOutputStream()
            kucukBitmap.compress(Bitmap.CompressFormat.PNG, 50, outputStream)
            val byteDizisi = outputStream.toByteArray()

            try {
                context?.let {
                    val database = it.openOrCreateDatabase("FoodDB", Context.MODE_PRIVATE, null)
                    database.execSQL("CREATE TABLE IF NOT EXISTS tbl_Food (food_Id INTEGER PRIMARY KEY, food_Name VARCHAR, food_Material VARCHAR, food_Image BLOB )")

                    val sqlString =
                        "INSERT INTO tbl_Food  (food_Name, food_Material, food_Image) VALUES (?,?,?)"
                    val statement = database.compileStatement(sqlString)
                    statement.bindString(1, foodName)
                    statement.bindString(2, foodMaterial)
                    statement.bindBlob(3, byteDizisi)
                    statement.execute()
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

            val action = FoodDetailFragmentDirections.actionFoodDetailFragmentToFoodListFragment()
            Navigation.findNavController(view).navigate(action)
        }
    }

    private fun imageSave(view: View) {
        //permission
        activity?.let {
            if (ContextCompat.checkSelfPermission(
                    it.applicationContext,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                //izin isteme kodu
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
            } else {
                //izin verilmiş, tekrar istemeye grek yok
                val galeriIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeriIntent, 2000)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1000) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //izin alındı
                val galeriIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeriIntent, 2000)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    //resim secildikten sonra geriye donen sonuc
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 2000 && resultCode == Activity.RESULT_OK && data != null) {
            secilenGorsel = data.data

            try {
                context?.let {
                    if (secilenGorsel != null) {
                        if (Build.VERSION.SDK_INT >= 29) {
                            val source =
                                ImageDecoder.createSource(it.contentResolver, secilenGorsel!!)
                            secilenBitmap = ImageDecoder.decodeBitmap(source)
                            detail_Image.setImageBitmap(secilenBitmap)
                        } else {
                            secilenBitmap =
                                MediaStore.Images.Media.getBitmap(it.contentResolver, secilenGorsel)
                            detail_Image.setImageBitmap(secilenBitmap)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun smallBitmapCreate(selectedBitmap: Bitmap, maxSize: Int): Bitmap {
        var width = selectedBitmap.width
        var height = selectedBitmap.height

        val bitmapRate: Double = width.toDouble() / height.toDouble()

        if (bitmapRate > 1) {
            //gorsel yatay
            width = maxSize
            val kisaltilmisHeight = width / bitmapRate
            height = kisaltilmisHeight.toInt()
        } else {
            height = maxSize
            val kisaltilmisWidth = height * bitmapRate
            width = kisaltilmisWidth.toInt()
        }
        return Bitmap.createScaledBitmap(selectedBitmap, width, height, true)
    }
}