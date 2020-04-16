package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_exercise.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.utils.recycler.elements.ExerciseElement
import ru.ok.technopolis.training.personal.utils.recycler.adapters.ExerciseElementAdapter
import ru.ok.technopolis.training.personal.utils.ExerciseListener

class ExerciseFragment : BaseFragment(), View.OnClickListener {

    private var recyclerView: RecyclerView? = null
    private var saveButton: Button? = null
    private var cancelButton: Button? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        recyclerView = fragment_workout__elements_list
        saveButton = fragment_workout__save
        cancelButton = fragment_workout__cancel

        saveButton?.setOnClickListener(this)
        cancelButton?.setOnClickListener(this)

        val exerciseElementAdapter = ExerciseElementAdapter(ArrayList(
                listOf(
                        ExerciseElement("Title1", 5, 0, 0),
                        ExerciseElement("Title2", 5, 1, 1),
                        ExerciseElement("Title3", 5, 2, 2)
                )
        ))

        recyclerView?.adapter = exerciseElementAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)

        super.onActivityCreated(savedInstanceState)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_exercise

    override fun onClick(v: View?) {
        if (v != null) {
            if (v === saveButton) {
                (activity as ExerciseListener).onExerciseSaved(0)
            } else if (v === cancelButton) {
                (activity as ExerciseListener).onExerciseCanceled(0)
            }
        }
    }

}