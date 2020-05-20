package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.UserWorkoutEntity

@Dao
interface UserWorkoutDao {
    @Query("SELECT * FROM UserWorkoutEntity")
    fun getAll(): List<UserWorkoutEntity>

    @Query("SELECT * FROM UserWorkoutEntity WHERE id = :id")
    fun getById(id: Int): UserWorkoutEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userWorkoutEntity: UserWorkoutEntity): Long

    @Delete
    fun delete(userWorkoutEntity: UserWorkoutEntity): Long
}