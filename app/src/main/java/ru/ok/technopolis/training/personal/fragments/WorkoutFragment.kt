package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_workout.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.items.WorkoutItem
import ru.ok.technopolis.training.personal.utils.logger.Logger
import ru.ok.technopolis.training.personal.utils.recycler.adapters.BaseListAdapter
import ru.ok.technopolis.training.personal.utils.recycler.adapters.ExerciseListAdapter
import ru.ok.technopolis.training.personal.viewholders.WorkoutElementViewHolder

class WorkoutFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null
    private var addExerciseButton: ImageView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = elements_list
        addExerciseButton = add_exercise_button
        addExerciseButton?.setOnClickListener {
            router?.showExercisePage()
        }

        val elements = ItemsList(mutableListOf(
                WorkoutItem("id1", R.drawable.ic_account_circle_black_24dp, "Title 1", "Sample description 1"),
                WorkoutItem("id2", R.drawable.ic_account_circle_black_24dp, "Title 2", "Sample description 2"),
                WorkoutItem("id3", R.drawable.ic_account_circle_black_24dp, "Title 3", "Sample description 3"),
                WorkoutItem("id4", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id5", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id6", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id7", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id8", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id9", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id10", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id11", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id12", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id13", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id14", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id15", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id16", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id17", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id18", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id19", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id20", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4")
        ))

        val workoutElementAdapter = ExerciseListAdapter(
                holderType = WorkoutElementViewHolder::class,
                layoutId = R.layout.item_workout_element,
                dataSource = elements,
                onClick = {
                    router?.showExercisePage()
                },
                onDeleteExerciseClick = {
                    elements.remove(it)
                }
        )

        recyclerView?.adapter = workoutElementAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Logger.d(this, "onCreateOptionsMenu")
        inflater.inflate(R.menu.new_workout, menu)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_workout
}
