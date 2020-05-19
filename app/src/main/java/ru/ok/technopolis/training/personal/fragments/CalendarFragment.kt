package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_calendar.view.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.items.Workout
import ru.ok.technopolis.training.personal.utils.recycler.adapters.CalendarWorkoutListAdapter
import ru.ok.technopolis.training.personal.viewholders.WorkoutViewHolder

class CalendarFragment : BaseFragment() {

    var calendar: CalendarView? = null
    var addWorkoutButton: ImageView? = null
    var recyclerView: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendar = view.calendar

        addWorkoutButton = view.add_workout_button
        addWorkoutButton?.setOnClickListener {
            router?.showWorkoutPage()
        }

        recyclerView = view.workout_list

        val elements = ItemsList(mutableListOf(
                Workout("id1", "8:00", "Training 1"),
                Workout("id2", "14:00", "Training 2"),
                Workout("id3", "20:00", "Training 3")
        ))

        val workoutAdapter = CalendarWorkoutListAdapter(
                holderType = WorkoutViewHolder::class,
                layoutId = R.layout.item_workout,
                dataSource = elements,
                onClick = {
                    router?.showWorkoutPage()
                },
                onStartWorkoutClick = {
                    router?.showActiveExercisePage()
                },
                onDeleteWorkoutClick = {
                    elements.remove(it)
                }
        )

        recyclerView?.adapter = workoutAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_calendar
}