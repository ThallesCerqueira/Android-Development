package devandroid.thalles.appmotivation.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import devandroid.thalles.appmotivation.infra.MotivationConstants
import devandroid.thalles.appmotivation.R
import devandroid.thalles.appmotivation.infra.SecurityPreferences
import devandroid.thalles.appmotivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView(binding.root)

        // Esconde a barra de navegação
        supportActionBar?.hide()

        handleUserName()
        handleFilter(R.id.ic_infinit)

        // Eventos de navegação
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.icSentiment.setOnClickListener(this)
        binding.icInfinit.setOnClickListener(this)
        binding.icSun.setOnClickListener(this)

    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textHello.text = "Olá, $name!"
    }

    override fun onClick(view: View) {

        if(view.id == R.id.button_new_phrase) {
            var s = ""
        } else if( view.id in listOf( R.id.ic_infinit, R.id.ic_sun, R.id.ic_sentiment ) ) {
            handleFilter(view.id)
        }

    }

    private fun handleFilter(id: Int) {

        binding.icInfinit.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.icSentiment.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.icSun.setColorFilter(ContextCompat.getColor(this, R.color.black))

        when (id) {
            R.id.ic_infinit -> {
                binding.icInfinit.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.INFINIT
            }
            R.id.ic_sentiment -> {
                binding.icSentiment.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SENTIMENT
            }
            R.id.ic_sun -> {
                binding.icSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUN

            }
        }
    }


}