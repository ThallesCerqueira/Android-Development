package devandroid.thalles.appmotivation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import devandroid.thalles.appmotivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView(binding.root)

        // Esconde a barra de navegação
        supportActionBar?.hide()

        handleUserName()

        // Eventos de navegação
        binding.buttonNewPhrase.setOnClickListener(this)

    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString( MotivationConstants.KEY.USER_NAME )
        binding.textHello.text = "Olá, $name!"
    }

    override fun onClick(view: View) {

        if(view.id == R.id.button_new_phrase) {
            var s = ""
        }

    }


}