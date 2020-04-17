package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.ok.technopolis.training.personal.activities.BaseActivity
import ru.ok.technopolis.training.personal.lifecycle.Router

abstract class BaseFragment : Fragment() {

    var router: Router? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        router = (activity as BaseActivity).router
        return inflater.inflate(getFragmentLayoutId(), container, false) as ViewGroup
    }

    abstract fun getFragmentLayoutId(): Int
}
