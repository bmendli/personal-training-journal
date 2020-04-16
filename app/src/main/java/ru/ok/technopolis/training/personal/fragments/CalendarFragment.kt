package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import ru.ok.technopolis.training.personal.R

class CalendarFragment : BaseFragment() {

    var calendar: CalendarView? = null
    var buttonAddWorkout: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = super.onCreateView(inflater, container, savedInstanceState)

        calendar = (rootView?.findViewById(R.id.fragment_calendar__calendar)) as CalendarView
        buttonAddWorkout = (rootView.findViewById(R.id.fragment_calendar__add_workout_button)) as Button

        return rootView
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_calendar

}