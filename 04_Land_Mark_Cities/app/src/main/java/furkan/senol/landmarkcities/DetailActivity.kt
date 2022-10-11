package furkan.senol.landmarkcities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import furkan.senol.landmarkcities.databinding.ActivityDetailBinding

private lateinit var binding: ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        //casting
        val selectedLandmark=intent.getSerializableExtra("landmark")  as Landmark
        binding.detailText.text= selectedLandmark.name
        binding.detailImageView.setImageResource(selectedLandmark.image)
    }
}