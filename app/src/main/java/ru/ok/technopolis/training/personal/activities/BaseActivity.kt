package ru.ok.technopolis.training.personal.activities

import android.os.Bundle
import android.util.Log
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(this::class.java.canonicalName, "Activity created")
        setContentView(getLayoutId())
    }

    abstract fun getLayoutId(): Int
}