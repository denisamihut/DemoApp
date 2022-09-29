package com.mihut.bmi_application.factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mihut.bmi_application.viewmodel.BmiStatusViewModel
class BmiStatusActivityViewModelFactory(private val computedBmiValue: Double) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BmiStatusViewModel::class.java)) {
            return BmiStatusViewModel(computedBmiValue) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}