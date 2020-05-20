package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.ParameterTypeEntity

@Dao
interface ParameterTypeDao {
    @Query("SELECT * FROM ParameterTypeEntity")
    fun getAll(): List<ParameterTypeEntity>

    @Query("SELECT * FROM ParameterTypeEntity WHERE id = :id")
    fun getById(id: Int): ParameterTypeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(parameterTypeEntity: ParameterTypeEntity): Long

    @Delete
    fun delete(parameterTypeEntity: ParameterTypeEntity): Long
}