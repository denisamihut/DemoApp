package com.mihut.bmi_application.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Math.round
import kotlin.math.pow
class MainViewModel : ViewModel() {
    var bmiLiveData = MutableLiveData<Double>()
    var validationMessageLiveData = MutableLiveData<String>()

    fun computeBmi(weight: String, height: String) {
        var computedBmi: Double
        if (weight.trim().isEmpty() || height.trim().isEmpty()) {
            validationMessageLiveData.value = "The input field(s) should not be left blank"
        } else {
            val numerator = weight.toFloat()
            val denominator = (height.toFloat() * 0.01).pow(2.0)
            computedBmi = numerator / denominator
            computedBmi = round(computedBmi * 10.0) / 10.0
            bmiLiveData.value = computedBmi
        }
    }
}