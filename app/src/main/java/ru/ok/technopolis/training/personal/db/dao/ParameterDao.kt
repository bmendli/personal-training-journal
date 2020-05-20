package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.ParameterEntity

@Dao
interface ParameterDao {
    @Query("SELECT * FROM ParameterEntity")
    fun getAll(): List<ParameterEntity>

    @Query("SELECT * FROM ParameterEntity WHERE id = :id")
    fun getById(id: Int): ParameterEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(parameterEntity: ParameterEntity): Long

    @Delete
    fun delete(parameterEntity: ParameterEntity): Long
}