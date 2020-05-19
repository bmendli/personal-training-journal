package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_exercise.*
import kotlinx.android.synthetic.main.item_exercise_element.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.items.Parameter
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.utils.logger.Logger
import ru.ok.technopolis.training.personal.utils.recycler.adapters.BaseListAdapter
import ru.ok.technopolis.training.personal.utils.recycler.adapters.ParameterListAdapter
import ru.ok.technopolis.training.personal.viewholders.ExerciseElementViewHolder

class ExerciseFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null
    private var addParameterButton: ImageView? = null
    private var removeParameterButton: ImageView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = elements_list
        addParameterButton = add_parameter_button
        removeParameterButton = delete_parameter_button

        val list = mutableListOf(
                Parameter("id1", "Title1", 5, 0, 0),
                Parameter("id2", "Title2", 5, 1, 1),
                Parameter("id3", "Title3", 5, 2, 2)
        )
        val elements = ItemsList(list)

        val exerciseElementAdapter = ParameterListAdapter(
                holderType = ExerciseElementViewHolder::class,
                layoutId = R.layout.item_exercise_element,
                dataSource = elements,
                onDeleteParameterClick = {
                    elements.remove(it)
                }
        )

        recyclerView?.adapter = exerciseElementAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)

        addParameterButton?.setOnClickListener {
            elements.add(Parameter("id" + elements.size(), "Title", 0, 0, 0))
        }

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Logger.d(this, "onCreateOptionsMenu")
        inflater.inflate(R.menu.new_workout, menu)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_exercise
}
