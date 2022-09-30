package com.mihut.bmi_application.view
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiStatusViewModel(val computedBmiValue: Double) : ViewModel() {
    var bmiValuesListLiveData = MutableLiveData<MutableList<BmiItem>>()
    init {
        bmiValuesListLiveData.value = computeBmiStatus()
    }
    private fun computeBmiStatus(): MutableList<BmiItem> {
        var bmiStatusList = getBmiStatusList()
        when (computedBmiValue) {
            in 0.0..14.9 -> bmiStatusList[0].isHighlighted = true
            in 15.0..16.0 -> bmiStatusList[1].isHighlighted = true
            in 16.1..18.4 -> bmiStatusList[2].isHighlighted = true
            in 18.5..24.9 -> bmiStatusList[3].isHighlighted = true
            in 25.0..29.9 -> bmiStatusList[4].isHighlighted = true
            in 30.0..34.9 -> bmiStatusList[5].isHighlighted = true
            in 35.0..39.9 -> bmiStatusList[6].isHighlighted = true
            else -> {
                bmiStatusList[7].isHighlighted = true
            }
        }
        return bmiStatusList
    }
    private fun getBmiStatusList(): MutableList<BmiItem> {
        val bmiStatusList = mutableListOf<BmiItem>()
        bmiStatusList.add(BmiItem("Less than 15.0", "Very severely underweight"))
        bmiStatusList.add(BmiItem("15.0 - 16.0", "Severely underweight"))
        bmiStatusList.add(BmiItem("16.1 - 18.4", "Underweight"))
        bmiStatusList.add(BmiItem("18.5 - 24.9", "Normal"))
        bmiStatusList.add(BmiItem("25.0 - 29.9", "Overweight"))
        bmiStatusList.add(BmiItem("30.0 - 34.9", "Obese Class I (Moderately Obese)"))
        bmiStatusList.add(BmiItem("35.0 - 39.9", "Obese Class II (Severely Obese)"))
        bmiStatusList.add(BmiItem("Above 40", "Obese Class III (Very Severely Obese)"))
        return bmiStatusList
    }
}