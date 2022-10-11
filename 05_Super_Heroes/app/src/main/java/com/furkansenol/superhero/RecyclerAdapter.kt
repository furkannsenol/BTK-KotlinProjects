package com.furkansenol.superhero

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter(val superHeroNameList: ArrayList<String>, val superHeroPictureList: ArrayList<Int>): RecyclerView.Adapter<RecyclerAdapter.SuperHeroVH>() {
    class SuperHeroVH(itemView : View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroVH {
        //inflater xml ile kod arasındaki yapı
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return SuperHeroVH(itemView)
    }

    override fun onBindViewHolder(holder: SuperHeroVH, position: Int) {
        //recyclerviewda ki itemlere ulaşma
        //apply plugin: 'kotlin-android-extensions' rowname idsine ulaşmak için eklemek gerekiyor
        holder.itemView.recyclerRowName.text=superHeroNameList.get(position)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("superHeroNameInfo",superHeroNameList.get(position))
            intent.putExtra("superHeroPicInfo",superHeroPictureList.get(position))
            /*val singletonClass = SingletonClass.SelectedHero
            singletonClass.heroImage=superHeroPictureList.get(position)*/

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        //Recycler view içerisinde kaç eleman olacak
        return superHeroNameList.size
    }
}