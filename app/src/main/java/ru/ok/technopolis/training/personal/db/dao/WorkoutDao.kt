package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.WorkoutEntity

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM WorkoutEntity")
    fun getAll(): List<WorkoutEntity>

    @Query("SELECT * FROM WorkoutEntity WHERE id = :id")
    fun getById(id: Int): WorkoutEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(workoutEntity: WorkoutEntity): Long

    @Delete
    fun delete(workoutEntity: WorkoutEntity): Long
}