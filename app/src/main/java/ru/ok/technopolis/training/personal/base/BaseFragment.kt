package ru.ok.technopolis.training.personal.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract fun getFragmentLayoutId(): Int
}