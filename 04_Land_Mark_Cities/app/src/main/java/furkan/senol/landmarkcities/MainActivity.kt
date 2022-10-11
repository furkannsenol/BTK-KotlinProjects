package furkan.senol.landmarkcities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import furkan.senol.landmarkcities.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

//private lateinit var landmarkList: ArrayList<Landmark>
private lateinit var landmarkArray: ArrayList<Landmark>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //arrayListOf kullanımı
        landmarkArray = arrayListOf<Landmark>(
            Landmark("Colosseum", "Italy", R.drawable.colosseum),
            Landmark("Pisa", "Italy", R.drawable.pisa),
            Landmark("Eiffel", "Italy", R.drawable.eiffel),
            Landmark("London Bridge", "Italy", R.drawable.londonbridge),
            Landmark("Colosseum", "Italy", R.drawable.colosseum),
            Landmark("Pisa", "Italy", R.drawable.pisa),
            Landmark("Eiffel", "Italy", R.drawable.eiffel),
            Landmark("London Bridge", "Italy", R.drawable.londonbridge),
            Landmark("Colosseum", "Italy", R.drawable.colosseum),
            Landmark("Pisa", "Italy", R.drawable.pisa),
            Landmark("Eiffel", "Italy", R.drawable.eiffel),
            Landmark("London Bridge", "Italy", R.drawable.londonbridge),
            Landmark("Colosseum", "Italy", R.drawable.colosseum),
            Landmark("Pisa", "Italy", R.drawable.pisa),
            Landmark("Eiffel", "Italy", R.drawable.eiffel),
            Landmark("London Bridge", "Italy", R.drawable.londonbridge),
            Landmark("Colosseum", "Italy", R.drawable.colosseum),
            Landmark("Colosseum", "Italy", R.drawable.colosseum),
            Landmark("Pisa", "Italy", R.drawable.pisa),
            Landmark("Eiffel", "Italy", R.drawable.eiffel),
            Landmark("London Bridge", "Italy", R.drawable.londonbridge),
            Landmark("Colosseum", "Italy", R.drawable.colosseum),
        )
        /* //ArrayList
        landmarkList = arrayListOf<Landmark>()

        //data
        val colosseum=Landmark("Colosseum","Italy",R.drawable.colosseum)
        val pisa=Landmark("Pisa","Italy",R.drawable.pisa)
        val eiffel=Landmark("Eiffel","Italy",R.drawable.eiffel)
        val londonBridge=Landmark("London Bridge","Italy",R.drawable.londonbridge)

        landmarkList.add(colosseum)
        landmarkList.add(pisa)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)
        */

        //ListView'a veri gönderme
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            landmarkArray.map { landmark -> landmark.name })
        binding.landMarkListView.adapter = adapter

        binding.landMarkListView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                //putextra da sınıf kullanılmaya calıstıgından landmark sınıfını serilazieble etmek gerekiyor
                intent.putExtra("landmark", landmarkArray.get(position))
                startActivity(intent)
            }

    }
}