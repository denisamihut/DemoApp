package com.mihut.bmi_application.view
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mihut.bmi_application.R
import com.mihut.bmi_application.adapter.BmiValuesListAdapter
import com.mihut.bmi_application.databinding.ActivityBmiStatusBinding
import com.mihut.bmi_application.factory.BmiStatusActivityViewModelFactory
import com.mihut.bmi_application.viewmodel.BmiStatusViewModel

class BmiStatusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBmiStatusBinding
    private lateinit var viewModel: BmiStatusViewModel
    private var computedBmiValue: Double = 0.0
    private lateinit var viewModelFactory: BmiStatusActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bmi_status)
        computedBmiValue = intent.getDoubleExtra("BMI_Value", 0.0)
        binding.bmiValue.text = computedBmiValue.toString()
        binding.bmiValuesTable.layoutManager = LinearLayoutManager(this)
        viewModelFactory = BmiStatusActivityViewModelFactory(computedBmiValue)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(BmiStatusViewModel::class.java)
        viewModel.bmiValuesListLiveData.observe(this, Observer { bmiValuesList ->
            binding.bmiValuesTable.adapter =
                BmiValuesListAdapter(applicationContext, bmiValuesList)
            (binding.bmiValuesTable.adapter as BmiValuesListAdapter).notifyDataSetChanged()
        })
    }
}