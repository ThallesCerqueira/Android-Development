package devandroid.thalles.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import devandroid.thalles.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        if( view.id == R.id.button_calculate ) {
            calculate()
        }

    }

    private fun calculate() {

        var distance = 0f
        var price = 0f
        var autonomy = 0f
        var totalValue = 0f

        if( isValid() ) {

            distance = binding.editDistance.text.toString().toFloat()
            price = binding.editPrice.text.toString().toFloat()
            autonomy = binding.editAutonomy.text.toString().toFloat()
            totalValue = (distance * price) / autonomy

            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

        } else {
            Toast.makeText( this, R.string.validation_fill_all_fields, Toast.LENGTH_SHORT ).show()
        }

    }

    private fun isValid(): Boolean {

        return binding.editDistance.text.toString() != "" &&
                binding.editPrice.text.toString() != "" &&
                binding.editAutonomy.text.toString() != "" &&
                binding.editAutonomy.text.toString().toFloat() != 0f
                binding.editDistance.text.toString().toFloat() != 0f
                binding.editPrice.text.toString().toFloat() != 0f

    }
}