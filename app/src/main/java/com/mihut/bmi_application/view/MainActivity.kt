package com.mihut.bmi_application.view
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mihut.bmi_application.R
import com.mihut.bmi_application.databinding.ActivityMainBinding
import com.mihut.bmi_application.viewmodel.MainViewModel
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.computeBmiButton.setOnClickListener {
            viewModel.computeBmi(
                binding.weightEditText.text.toString(),
                binding.heightEditText.text.toString()
            )
        }
        viewModel.validationMessageLiveData.observe(this, Observer { errorMessage ->
            showToastMessage(errorMessage)
        })
        viewModel.bmiLiveData.observe(this, Observer { bmiValue ->
            launchChartActivity(bmiValue)
        })
    }
    private fun showToastMessage(message: String?) {
        Toast.makeText(
            applicationContext,
            message,
            LENGTH_LONG
        ).show()
    }
    private fun launchChartActivity(bmiValue: Double) {
        val intent = Intent(this@MainActivity, BmiStatusActivity::class.java)
        intent.putExtra("BMI_Value", bmiValue)
        startActivity(intent)
    }
}