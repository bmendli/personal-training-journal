package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.UserWorkoutEntity

@Dao
interface UserWorkoutDao {
    @Query("SELECT * FROM UserWorkoutEntity")
    fun getAll(): List<UserWorkoutEntity>

    @Query("SELECT * FROM UserWorkoutEntity WHERE id = :id")
    fun getById(id: Long): UserWorkoutEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userWorkoutEntity: UserWorkoutEntity): Long

    @Insert
    fun insert(userWorkoutEntityList: List<UserWorkoutEntity>): List<Long>

    @Update
    fun update(userWorkoutEntity: UserWorkoutEntity): Int

    @Update
    fun update(userWorkoutEntityList: List<UserWorkoutEntity>): Int

    @Delete
    fun delete(userWorkoutEntity: UserWorkoutEntity): Int
}