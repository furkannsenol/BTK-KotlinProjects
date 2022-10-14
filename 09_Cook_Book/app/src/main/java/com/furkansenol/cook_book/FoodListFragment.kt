package com.furkansenol.cook_book

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_food_list.*

class FoodListFragment : Fragment() {
    var yemekIsmiListesi = ArrayList<String>()
    var yemekIdListesi = ArrayList<Int>()
    private lateinit var listAdapter:ListRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sqlVeriAlma()

        listAdapter= ListRecyclerAdapter(yemekIsmiListesi,yemekIdListesi)
        foodRV.layoutManager=LinearLayoutManager(context)
        foodRV.adapter=listAdapter

        super.onViewCreated(view, savedInstanceState)
    }

    fun sqlVeriAlma() {
        try {
            activity?.let {
                val database = it.openOrCreateDatabase("FoodDB", Context.MODE_PRIVATE, null)
                val cursor = database.rawQuery("SELECT * FROM tbl_Food", null)
                val yemekIsmiIndex = cursor.getColumnIndex("food_Name")
                val yemekIdIndex = cursor.getColumnIndex("food_Id")
                val yemekIsmiIndex2 = cursor.getColumnIndex("food_Material")

                while (cursor.moveToNext()) {
                    yemekIsmiListesi.add(cursor.getString(yemekIsmiIndex))
                    yemekIdListesi.add(cursor.getInt(yemekIdIndex))
                }

                listAdapter.notifyDataSetChanged()
                cursor.close()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}