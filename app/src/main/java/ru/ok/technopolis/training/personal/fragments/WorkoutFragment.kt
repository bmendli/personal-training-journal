package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_exercise.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.utils.*
import ru.ok.technopolis.training.personal.utils.recycler.adapters.WorkoutElementAdapter
import ru.ok.technopolis.training.personal.utils.recycler.elements.WorkoutElement

class WorkoutFragment : BaseFragment(), View.OnClickListener {

    private var recyclerView: RecyclerView? = null
    private var addExerciseButton: ImageButton? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        recyclerView = fragment_workout__elements_list
        addExerciseButton = fragment_workout__add_exercise_button

        addExerciseButton?.setOnClickListener(this)

        val workoutElementAdapter = WorkoutElementAdapter(ArrayList(
                listOf(
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 1", "Sample description 1"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 2", "Sample description 2"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 3", "Sample description 3"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 5", "Sample description 5"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 6", "Sample description 6"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 7", "Sample description 7"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 8", "Sample description 8")
                )
        ), this)

        recyclerView?.adapter = workoutElementAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)

        super.onActivityCreated(savedInstanceState)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_workout

    override fun onClick(v: View?) {
        if (v != null) {
            if (v === addExerciseButton) {
                (activity as ExerciseListener).onExerciseAdding()
            } else {
                val exerciseId = recyclerView?.getChildLayoutPosition(v)
                if (exerciseId != null && exerciseId != -1) {
                    (activity as ExerciseListener).onExerciseClicked(exerciseId)
                }
            }
        }
    }

}