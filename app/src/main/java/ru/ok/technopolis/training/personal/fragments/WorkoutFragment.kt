package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_workout.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.utils.*
import ru.ok.technopolis.training.personal.utils.recycler.adapters.WorkoutElementAdapter
import ru.ok.technopolis.training.personal.utils.recycler.elements.WorkoutElement

class WorkoutFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null
    private var addExerciseButton: ImageButton? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = elements_list
        addExerciseButton = add_exercise_button

        addExerciseButton?.setOnClickListener { (activity as? ExerciseListener)?.onExerciseAdding() }

        val workoutElementAdapter = WorkoutElementAdapter(listOf(
                WorkoutElement("id1", R.drawable.ic_account_circle_black_24dp, "Title 1", "Sample description 1"),
                WorkoutElement("id2", R.drawable.ic_account_circle_black_24dp, "Title 2", "Sample description 2"),
                WorkoutElement("id3", R.drawable.ic_account_circle_black_24dp, "Title 3", "Sample description 3"),
                WorkoutElement("id4", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutElement("id5", R.drawable.ic_account_circle_black_24dp, "Title 5", "Sample description 5"),
                WorkoutElement("id6", R.drawable.ic_account_circle_black_24dp, "Title 6", "Sample description 6"),
                WorkoutElement("id7", R.drawable.ic_account_circle_black_24dp, "Title 7", "Sample description 7"),
                WorkoutElement("id8", R.drawable.ic_account_circle_black_24dp, "Title 8", "Sample description 8")
        )) { exerciseId ->
            (activity as? ExerciseListener)?.onExerciseClicked(exerciseId)
        }

        recyclerView?.adapter = workoutElementAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_workout

}
