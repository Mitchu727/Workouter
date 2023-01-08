package com.example.workouter.persistence

interface ActivitiesRepository {

    fun insert(activities: List<String>)

}

class FirebaseActivititesRepository: ActivitiesRepository {
    override fun insert(activities: List<String>) {
        print("Inserting to database: ${activities.toString()}" )
    }
}