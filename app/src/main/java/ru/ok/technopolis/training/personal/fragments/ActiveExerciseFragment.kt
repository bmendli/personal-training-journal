package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.frgment_active_exercise.*
import kotlinx.android.synthetic.main.frgment_active_exercise.view.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.items.ActiveExerciseItem
import ru.ok.technopolis.training.personal.utils.recycler.adapters.BaseListAdapter
import ru.ok.technopolis.training.personal.viewholders.ActiveExerciseViewHolder

class ActiveExerciseFragment : BaseFragment() {

    private var goBackView: ImageView? = null
    private var setStarView: ImageView? = null
    private var setBookmarkView: ImageView? = null

    private var doneButton: Button? = null
    private var nextExerciseButton: TextView? = null
    private var parametersList: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parametersList = view.parameters_view
        goBackView = view.go_back
        setStarView = view.star_border
        setBookmarkView = view.bookmark_border
        doneButton = view.done_button
        nextExerciseButton = view.next_exercise_name
        doneButton?.setOnClickListener {
            router?.showWorkoutPage()
        }
        nextExerciseButton?.setOnClickListener {
            router?.showActiveExercisePage()
        }

        val parameters = Observable.just(listOf(
                ActiveExerciseItem("id1", "Title1", 5, 0, 0),
                ActiveExerciseItem("id2", "Title2", 5, 1, 1),
                ActiveExerciseItem("id3", "Title3", 5, 2, 2)
                )
        )

        val exerciseElementAdapter = BaseListAdapter(
            holderType = ActiveExerciseViewHolder::class,
            layoutId = R.layout.item_active_exercise_element,
            dataSource = parameters
        )

        parametersList?.adapter = exerciseElementAdapter
        parametersList?.layoutManager = LinearLayoutManager(activity)
    }

    override fun getFragmentLayoutId(): Int = R.layout.frgment_active_exercise
}
