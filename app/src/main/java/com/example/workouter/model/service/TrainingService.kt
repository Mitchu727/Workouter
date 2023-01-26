package com.example.workouter.model.service

import com.example.workouter.model.Training

interface TrainingService {
    val currentTraining: Training
    suspend fun startNewTraining(): String
    suspend fun getCurrentTraining(): Training
}

class DefaultTrainingService(
    val storageService: StorageService
): TrainingService {
    override var currentTraining = Training()
    override suspend fun startNewTraining(): String {
        currentTraining = Training.createNew()
        return storageService.createNewTraining(currentTraining)
    }

    override suspend fun getCurrentTraining():Training {
        return currentTraining
    }
}

