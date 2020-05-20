package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.UserWorkoutParameterValueEntity

@Dao
interface UserWorkoutParameterValueDao {
    @Query("SELECT * FROM UserWorkoutParameterValueEntity")
    fun getAll(): List<UserWorkoutParameterValueEntity>

    @Query("SELECT * FROM UserWorkoutParameterValueEntity WHERE id = :id")
    fun getById(id: Int): UserWorkoutParameterValueEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userWorkoutParameterValueEntity: UserWorkoutParameterValueEntity): Long

    @Delete
    fun delete(userWorkoutParameterValueEntity: UserWorkoutParameterValueEntity): Long
}