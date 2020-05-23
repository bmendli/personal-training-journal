package ru.ok.technopolis.training.personal.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_workout.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.db.entity.ExerciseEntity
import ru.ok.technopolis.training.personal.db.entity.WorkoutEntity
import ru.ok.technopolis.training.personal.db.entity.WorkoutExerciseEntity
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.lifecycle.Page.Companion.WORKOUT_ID_KEY
import ru.ok.technopolis.training.personal.utils.logger.Logger
import ru.ok.technopolis.training.personal.utils.recycler.adapters.ExerciseListAdapter
import ru.ok.technopolis.training.personal.viewholders.ExerciseViewHolder

class WorkoutFragment : BaseFragment() {

    private var workoutNameEditText: EditText? = null
    private var recyclerView: RecyclerView? = null
    private var addExerciseButton: ImageView? = null
    private var workout: WorkoutEntity? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workoutNameEditText = workout_name
        recyclerView = elements_list
        addExerciseButton = add_exercise_button

        GlobalScope.launch(Dispatchers.IO) {
            val workoutId = (activity?.intent?.extras?.get(WORKOUT_ID_KEY)) as Long
            val exerciseList = database?.workoutExerciseDao()?.getExercisesForWorkout(workoutId)!!
            workout = database?.workoutDao()?.getById(workoutId)

            withContext(Dispatchers.Main) {
                workoutNameEditText?.setText(workout?.name)
                val elements = ItemsList(exerciseList)

                val exerciseAdapter = ExerciseListAdapter(
                    holderType = ExerciseViewHolder::class,
                    layoutId = R.layout.item_workout_element,
                    dataSource = elements,
                    onClick = {
                        router?.showExercisePage(it.id)
                    },
                    onDeleteExerciseClick = {
                        GlobalScope.launch(Dispatchers.IO) {
                            database?.exerciseDao()?.delete(it)
                            withContext(Dispatchers.Main) {
                                elements.remove(it)
                            }
                        }
                    }
                )

                recyclerView?.adapter = exerciseAdapter
                recyclerView?.layoutManager = LinearLayoutManager(activity)
                recyclerView?.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))

                addExerciseButton?.setOnClickListener {
                    GlobalScope.launch(Dispatchers.IO) {
                        val exerciseEntity = ExerciseEntity("", "", 1)
                        exerciseEntity.id = database?.exerciseDao()?.insert(exerciseEntity)!!
                        database?.workoutExerciseDao()?.insert(WorkoutExerciseEntity(
                            workoutId,
                            exerciseEntity.id
                        ))
                        withContext(Dispatchers.Main) {
                            elements.add(
                                exerciseEntity
                            )
                            router?.showExercisePage(exerciseEntity.id)
                        }
                    }
                }
            }
        }

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Logger.d(this, "onCreateOptionsMenu")
        inflater.inflate(R.menu.apply_reject_menu, menu)
        val saveButton: MenuItem = menu.findItem(R.id.apply_changes)
        saveButton.setOnMenuItemClickListener {
            val workoutName = workoutNameEditText?.text.toString()
            if (workoutName == "") {
                workoutNameEditText?.setBackgroundColor(Color.RED)
            } else {
                GlobalScope.launch(Dispatchers.IO) {
                    workout?.name = workoutName
                    database?.workoutDao()?.update(workout!!)
                    withContext(Dispatchers.Main) {
                        router?.goToPrevFragment()
                    }
                }
            }
            true
        }
        val cancelButton: MenuItem = menu.findItem(R.id.reject_changes)
        cancelButton.setOnMenuItemClickListener {
            val workoutName = workoutNameEditText?.text.toString()
            GlobalScope.launch(Dispatchers.IO) {
                if (workoutName == "") {
                        database?.workoutDao()?.delete(workout!!)
                }
                withContext(Dispatchers.Main) {
                    router?.goToPrevFragment()
                }
            }

            true
        }
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_workout
}
