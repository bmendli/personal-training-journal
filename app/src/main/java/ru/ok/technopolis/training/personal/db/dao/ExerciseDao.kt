package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.ExerciseEntity

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM ExerciseEntity")
    fun getAll(): List<ExerciseEntity>

    @Query("SELECT * FROM ExerciseEntity WHERE id = :id")
    fun getById(id: Int): ExerciseEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exerciseEntity: ExerciseEntity): Long

    @Delete
    fun delete(exerciseEntity: ExerciseEntity): Long
}