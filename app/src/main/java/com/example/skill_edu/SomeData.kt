package com.example.skill_edu

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SomeData(val value1: String, val value2: Int) : Parcelable {
}