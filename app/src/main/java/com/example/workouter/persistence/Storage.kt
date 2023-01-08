package com.example.workouter.persistence

import android.content.Context
import com.example.workouter.domain.Exercise
import com.google.gson.GsonBuilder
import java.io.FileOutputStream
import java.io.IOException


interface PlannerStorage {

    fun insert(data: List<Exercise>, context: Context)

}

class FilePlannerStorage: PlannerStorage {
    val gson = GsonBuilder().create()

    override fun insert(data: List<Exercise>, context: Context) {
        try {
            val fileOutputStream: FileOutputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE)
            fileOutputStream.write(listOfExercisesToJson(data).toByteArray())
            fileOutputStream.flush()
            fileOutputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun listOfExercisesToJson(exercises: List<Exercise>): String {
        return gson.toJson(exercises)
    }

    companion object {
        val FILENAME: String = "data.json"
    }
}

