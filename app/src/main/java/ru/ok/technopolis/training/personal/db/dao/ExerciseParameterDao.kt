package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.ExerciseParameterEntity
import ru.ok.technopolis.training.personal.db.entity.ParameterEntity

@Dao
interface ExerciseParameterDao {
    @Query("SELECT * FROM ExerciseParameterEntity")
    fun getAll(): List<ExerciseParameterEntity>

    @Query("SELECT * FROM ParameterEntity AS pe " +
        "INNER JOIN ExerciseParameterEntity AS epe ON pe.id = epe.parameterId " +
        "WHERE epe.exerciseId = :exerciseId")
    fun getParametersForExercise(exerciseId: Long): List<ParameterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exerciseParameterEntity: ExerciseParameterEntity): Long

    @Insert
    fun insert(exerciseParameterEntity: List<ExerciseParameterEntity>): List<Long>

    @Update
    fun update(exerciseParameterEntity: ExerciseParameterEntity): Int

    @Update
    fun update(exerciseParameterEntityList: List<ExerciseParameterEntity>): Int

    @Delete
    fun delete(exerciseParameterEntity: ExerciseParameterEntity): Int
}