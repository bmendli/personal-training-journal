package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.ExerciseParameterEntity

@Dao
interface ExerciseParameterDao {
    @Query("SELECT * FROM ExerciseParameterEntity")
    fun getAll(): List<ExerciseParameterEntity>

    @Query("SELECT * FROM ExerciseParameterEntity WHERE id = :id")
    fun getById(id: Int): ExerciseParameterEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exerciseParameterEntity: ExerciseParameterEntity): Long

    @Delete
    fun delete(exerciseParameterEntity: ExerciseParameterEntity): Long
}