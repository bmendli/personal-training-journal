package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_exercise.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.recycler.elements.ExerciseElement
import ru.ok.technopolis.training.personal.recycler.adapters.ExerciseElementAdapter

class ExerciseFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null
    private var saveButton: Button? = null
    private var cancelButton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = elements_list
        saveButton = save
        cancelButton = cancel

//        Smth like
//        exerciseUtils.createExercise(exerciseItem)
//        or
//        exerciseUtils.updateExercise(exerciseItem)
//        where exerciseItem: ExerciseItem(name: String, elements: List<ExerciseElement)

//        saveButton?.setOnClickListener { (activity as? ExerciseListener)?.onExerciseSaved(0) }

//        Smth like
//        fragmentManager.goBack()
//        cancelButton?.setOnClickListener { (activity as? ExerciseListener)?.onExerciseCanceled(0) }

        val exerciseElementAdapter = ExerciseElementAdapter(listOf(
                    ExerciseElement("Title1", 5, 0, 0),
                    ExerciseElement("Title2", 5, 1, 1),
                    ExerciseElement("Title3", 5, 2, 2)
            )
        )

        recyclerView?.adapter = exerciseElementAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_exercise

}
