package ru.ok.technopolis.training.personal.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.ok.technopolis.training.personal.db.dao.*
import ru.ok.technopolis.training.personal.db.entity.*

@Database(
    entities = [
        ExerciseEntity::class,
        ExerciseParameterEntity::class,
        ExerciseTypeEntity::class,
        MeasureUnitEntity::class,
        ParameterEntity::class,
        ParameterTypeEntity::class,
        UserEntity::class,
        UserWorkoutEntity::class,
        UserWorkoutParameterValueEntity::class,
        WorkoutEntity::class,
        WorkoutExerciseEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
    abstract fun exerciseParameterDao(): ExerciseParameterDao
    abstract fun exerciseTypeDao(): ExerciseTypeDao
    abstract fun measureUnitDao(): MeasureUnitDao
    abstract fun parameterDao(): ParameterDao
    abstract fun parameterTypeDao(): ParameterTypeDao
    abstract fun userDao(): UserDao
    abstract fun userWorkoutDao(): UserWorkoutDao
    abstract fun userWorkoutParameterValueDao(): UserWorkoutParameterValueDao
    abstract fun workoutDao(): WorkoutDao
    abstract fun workoutExerciseDao(): WorkoutExerciseDao
}