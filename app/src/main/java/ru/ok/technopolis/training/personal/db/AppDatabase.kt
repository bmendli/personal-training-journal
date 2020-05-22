package ru.ok.technopolis.training.personal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.ok.technopolis.training.personal.db.converter.DateConverter
import ru.ok.technopolis.training.personal.db.dao.*
import ru.ok.technopolis.training.personal.db.entity.*
import ru.ok.technopolis.training.personal.db.generators.InitialDataGenerator

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
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME: String = "workoutJournalDB"

        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (instance != null) {
                return instance
            }

            return synchronized(this) {
                if (instance != null) {
                    instance
                } else {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DATABASE_NAME
                    ).addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            GlobalScope.launch(Dispatchers.IO) {
                                instance?.let {
                                    it.exerciseTypeDao().insert(InitialDataGenerator.getExerciseTypes())
                                    it.parameterTypeDao().insert(InitialDataGenerator.getParameterTypes())
                                    it.measureUnitDao().insert(InitialDataGenerator.getMeasureUnits())
                                }
                            }
                        }
                    })
                        .build()
                    instance
                }
            }
        }
    }

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