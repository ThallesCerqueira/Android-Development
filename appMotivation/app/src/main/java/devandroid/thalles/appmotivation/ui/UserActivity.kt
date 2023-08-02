package devandroid.thalles.appmotivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import devandroid.thalles.appmotivation.infra.MotivationConstants
import devandroid.thalles.appmotivation.R
import devandroid.thalles.appmotivation.infra.SecurityPreferences
import devandroid.thalles.appmotivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.buttonSave.setOnClickListener(this)

        verifyUserName()
    }

    private fun verifyUserName() {

        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

        if(name != "") {
            startActivity( Intent(this, MainActivity::class.java) )
            finish()
        }

    }

    override fun onClick(view: View) {

        if (view.id == R.id.button_save) {
            handleSave()
        }

    }

    private fun handleSave() {

        val name = binding.editYourName.text.toString()

        if (name != "") {
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
            startActivity( Intent(this, MainActivity::class.java) )
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }

    }
}