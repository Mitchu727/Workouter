package com.example.workouter.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Exercise(
    var name: String,
    var type: ExerciseType,
    var series: Int = 1
):Parcelable

enum class ExerciseType {
    TIMED,
    COUNTED
}