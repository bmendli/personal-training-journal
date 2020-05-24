package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.frgment_active_exercise.*
import kotlinx.android.synthetic.main.frgment_active_exercise.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.db.entity.ExerciseEntity
import ru.ok.technopolis.training.personal.db.entity.MeasureUnitEntity
import ru.ok.technopolis.training.personal.db.entity.ParameterTypeEntity
import ru.ok.technopolis.training.personal.db.entity.WorkoutEntity
import ru.ok.technopolis.training.personal.db.model.ParameterModel
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.lifecycle.Page.Companion.WORKOUT_ID_KEY
import ru.ok.technopolis.training.personal.utils.recycler.adapters.BaseListAdapter
import ru.ok.technopolis.training.personal.viewholders.ActiveExerciseViewHolder

class ActiveExerciseFragment : BaseFragment() {

    private var doneButton: Button? = null
    private var recyclerView: RecyclerView? = null
    private var workoutProgressBar: ProgressBar? = null
    private var workoutProgressText: TextView? = null
    private var exerciseName: TextView? = null
    private var progressBar: ProgressBar? = null

    private var workout: WorkoutEntity? = null
    private var exerciseList: List<ExerciseEntity>? = null
    private var exerciseIndex: Int = -1

    private var elements: ItemsList<ParameterModel> = ItemsList(mutableListOf())

    private var measureUnitChoices: MutableList<MeasureUnitEntity>? = null
    private var parameterTypeChoices: MutableList<ParameterTypeEntity>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.parameters_view
        doneButton = view.done_button
        progressBar = view.progress_bar
        workoutProgressBar = workout_progress_bar
        workoutProgressText = workout_progress_text
        exerciseName = name

        val activeExerciseAdapter = BaseListAdapter(
            holderType = ActiveExerciseViewHolder::class,
            layoutId = R.layout.item_active_exercise_element,
            dataSource = elements,
            onClick = {}
        )
        recyclerView?.adapter = activeExerciseAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))

        GlobalScope.launch(Dispatchers.IO) {
            activity?.runOnUiThread {
                progressBar?.visibility = View.VISIBLE
            }
            val workoutId = (activity?.intent?.extras?.get(WORKOUT_ID_KEY)) as Long
            database?.let { appDatabase ->
                exerciseList = appDatabase.workoutExerciseDao().getExercisesForWorkout(workoutId)
                workout = appDatabase.workoutDao().getById(workoutId)
                measureUnitChoices = appDatabase.measureUnitDao().getAll().toMutableList()
                parameterTypeChoices = appDatabase.parameterTypeDao().getAll().toMutableList()
            }
            withContext(Dispatchers.Main) {
                loadNextExercise()
                doneButton?.setOnClickListener {
                    loadNextExercise()
                }
            }
            activity?.runOnUiThread {
                progressBar?.visibility = View.GONE
            }
        }
    }

    private fun loadNextExercise() {
        ++exerciseIndex
        exerciseList?.let { list ->
            if (exerciseIndex < list.size) {
                val exercise = list[exerciseIndex]
                GlobalScope.launch(Dispatchers.IO) {
                    activity?.runOnUiThread {
                        progressBar?.visibility = View.VISIBLE
                    }
                    // load parameters for exercise
                    var parameterModelList: MutableList<ParameterModel>? = null
                    database?.let { appDatabase ->
                        val parameterList = appDatabase.exerciseParameterDao().getParametersForExercise(exercise.id)
                        parameterModelList = parameterList.map {
                            ParameterModel(it, measureUnitChoices!!, parameterTypeChoices!!)
                        }.toMutableList()
                    }
                    withContext(Dispatchers.Main) {
                        parameterModelList?.let { elements.setData(it) }
                        exerciseName?.text = exercise.name
                        val progressValue = (exerciseIndex * 100 / list.size)
                        workoutProgressBar?.setProgress(progressValue)
                    }
                    activity?.runOnUiThread {
                        progressBar?.visibility = View.GONE
                    }
                }
            } else {
                // workout is end
                Toast.makeText(context, "Workout done!", Toast.LENGTH_LONG).show()
                router?.showCalendarPage()
            }
        }
    }

    override fun getFragmentLayoutId(): Int = R.layout.frgment_active_exercise
}
