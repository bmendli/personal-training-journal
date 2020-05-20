package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.WorkoutExerciseEntity

@Dao
interface WorkoutExerciseDao {
    @Query("SELECT * FROM WorkoutExerciseEntity")
    fun getAll(): List<WorkoutExerciseEntity>

    @Query("SELECT * FROM WorkoutExerciseEntity WHERE id = :id")
    fun getById(id: Int): WorkoutExerciseEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(workoutExerciseEntity: WorkoutExerciseEntity): Long

    @Delete
    fun delete(workoutExerciseEntity: WorkoutExerciseEntity): Long
}