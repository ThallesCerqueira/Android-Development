package devandroid.thalles.appmotivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import devandroid.thalles.appmotivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.buttonSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        if(view.id == R.id.button_save) {
            handleSave()
        }

    }

    private fun handleSave() {

        val name = binding.editYourName.text.toString()

        if(name != "") {

        } else{
          Toast.makeText(this, "" )
        }

    }
}