package devandroid.thalles.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import devandroid.thalles.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonLogin.setOnClickListener(this)

        setObserver()

    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_login) {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            viewModel.doLogin(email, password)
        }
    }

    private fun setObserver() {
        viewModel.welcome().observe(this, Observer {
            binding.txtWelcome.text = it
        } )

        viewModel.login().observe(this, Observer {
            if(it == true) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_LONG).show()
            }
        })
    }

}