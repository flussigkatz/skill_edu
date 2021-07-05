package com.example.skill_edu

import androidx.databinding.InverseMethod

object Converter {
    @JvmStatic
    fun stringToDouble(value: String): Double {
        return if (value.isNotEmpty()) {
            value.toDouble()
        } else 0.0
    }

    @JvmStatic
    @InverseMethod("stringToDouble")
    fun doubleToString(value: Double):String {
        return String.format("%.2f", value)
    }

    @JvmStatic
    fun dolToRub(value: Double): Double {
        return  value * 75
    }

    @JvmStatic
    @InverseMethod("dolToRub")
    fun rubToDol(value: Double): Double {
        return value / 75
    }

}