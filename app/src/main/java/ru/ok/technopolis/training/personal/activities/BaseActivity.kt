package ru.ok.technopolis.training.personal.activities

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import ru.ok.technopolis.training.personal.lifecycle.Router
import ru.ok.technopolis.training.personal.utils.logger.Logger

abstract class BaseActivity : AppCompatActivity() {

    var router: Router? = null
        private set

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d(this, "onCreate")

        router = Router(this)

        setContentView(getActivityLayoutId())
    }

    protected abstract fun getActivityLayoutId(): Int
}