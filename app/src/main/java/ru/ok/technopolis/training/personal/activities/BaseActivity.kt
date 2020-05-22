package ru.ok.technopolis.training.personal.activities

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.room.RoomDatabase
import io.reactivex.disposables.CompositeDisposable
import ru.ok.technopolis.training.personal.db.AppDatabase
import ru.ok.technopolis.training.personal.lifecycle.Router
import ru.ok.technopolis.training.personal.utils.logger.Logger

abstract class BaseActivity : AppCompatActivity() {

    var router: Router? = null
        private set

    var database: AppDatabase? = null
        private set

    protected val taskContainer: CompositeDisposable = CompositeDisposable()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d(this, "onCreate")

        router = Router(this)
        database = AppDatabase.getInstance(applicationContext)

        setContentView(getActivityLayoutId())
    }

    override fun onDestroy() {
        super.onDestroy()
        taskContainer.dispose()
    }

    protected abstract fun getActivityLayoutId(): Int
}