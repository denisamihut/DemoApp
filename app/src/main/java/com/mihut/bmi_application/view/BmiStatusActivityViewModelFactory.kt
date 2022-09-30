package com.mihut.bmi_application.view
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BmiStatusActivityViewModelFactory(private val computedBmiValue: Double) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BmiStatusViewModel::class.java)) {
            return BmiStatusViewModel(computedBmiValue) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}