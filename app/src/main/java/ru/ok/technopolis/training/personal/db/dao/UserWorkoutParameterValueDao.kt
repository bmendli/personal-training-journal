package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.UserWorkoutParameterValueEntity

@Dao
interface UserWorkoutParameterValueDao {
    @Query("SELECT * FROM UserWorkoutParameterValueEntity")
    fun getAll(): List<UserWorkoutParameterValueEntity>

    @Query("SELECT * FROM UserWorkoutParameterValueEntity WHERE id = :id")
    fun getById(id: Long): UserWorkoutParameterValueEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userWorkoutParameterValueEntity: UserWorkoutParameterValueEntity): Long

    @Insert
    fun insert(userWorkoutParameterValueEntityList: List<UserWorkoutParameterValueEntity>): List<Long>

    @Update
    fun update(userWorkoutParameterValueEntity: UserWorkoutParameterValueEntity): Int

    @Update
    fun update(userWorkoutParameterValueEntityList: List<UserWorkoutParameterValueEntity>): Int

    @Delete
    fun delete(userWorkoutParameterValueEntity: UserWorkoutParameterValueEntity): Int
}