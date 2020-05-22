package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.ExerciseTypeEntity

@Dao
interface ExerciseTypeDao {
    @Query("SELECT * FROM ExerciseTypeEntity")
    fun getAll(): List<ExerciseTypeEntity>

    @Query("SELECT * FROM ExerciseTypeEntity WHERE id = :id")
    fun getById(id: Long): ExerciseTypeEntity

    @Insert
    fun insert(exerciseTypeEntity: ExerciseTypeEntity): Long

    @Insert
    fun insert(exerciseTypeEntityList: List<ExerciseTypeEntity>): List<Long>

    @Update
    fun update(exerciseTypeEntity: ExerciseTypeEntity): Int

    @Update
    fun update(exerciseTypeEntityList: List<ExerciseTypeEntity>): Int

    @Delete
    fun delete(exerciseTypeEntity: ExerciseTypeEntity): Int
}