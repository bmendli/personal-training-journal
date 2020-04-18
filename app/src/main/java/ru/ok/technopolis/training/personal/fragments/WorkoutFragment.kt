package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_workout.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.recycler.adapters.WorkoutElementAdapter
import ru.ok.technopolis.training.personal.recycler.elements.WorkoutElement

class WorkoutFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null
    private var addExerciseButton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = elements_list
        addExerciseButton = add_exercise_button

        val workoutElementAdapter = WorkoutElementAdapter(listOf(
                WorkoutElement("id1", R.drawable.ic_account_circle_black_24dp, "Title 1", "Sample description 1"),
                WorkoutElement("id2", R.drawable.ic_account_circle_black_24dp, "Title 2", "Sample description 2"),
                WorkoutElement("id3", R.drawable.ic_account_circle_black_24dp, "Title 3", "Sample description 3"),
                WorkoutElement("id4", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id5", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id6", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id7", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id8", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id9", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id10", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id11", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id12", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id13", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id14", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id15", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id16", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id17", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id18", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id19", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id20", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4")
        )) { element ->

        }

        recyclerView?.adapter = workoutElementAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_workout

}
