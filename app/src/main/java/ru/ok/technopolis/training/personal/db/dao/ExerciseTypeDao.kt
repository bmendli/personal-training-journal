package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.ExerciseTypeEntity

@Dao
interface ExerciseTypeDao {
    @Query("SELECT * FROM ExerciseTypeEntity")
    fun getAll(): List<ExerciseTypeEntity>

    @Query("SELECT * FROM ExerciseTypeEntity WHERE id = :id")
    fun getById(id: Int): ExerciseTypeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exerciseTypeEntity: ExerciseTypeEntity): Long

    @Delete
    fun delete(exerciseTypeEntity: ExerciseTypeEntity): Long
}