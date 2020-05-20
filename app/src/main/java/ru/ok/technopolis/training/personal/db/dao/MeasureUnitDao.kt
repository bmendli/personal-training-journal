package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.MeasureUnitEntity

@Dao
interface MeasureUnitDao {
    @Query("SELECT * FROM MeasureUnitEntity")
    fun getAll(): List<MeasureUnitEntity>

    @Query("SELECT * FROM MeasureUnitEntity WHERE id = :id")
    fun getById(id: Int): MeasureUnitEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(measureUnitEntity: MeasureUnitEntity): Long

    @Delete
    fun delete(measureUnitEntity: MeasureUnitEntity): Long
}