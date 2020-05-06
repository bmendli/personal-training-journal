package ru.ok.technopolis.training.personal.viewholders

import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.item_active_exercise_element.view.*
import kotlinx.android.synthetic.main.item_exercise_element.view.*
import kotlinx.android.synthetic.main.item_workout_element.view.*
import ru.ok.technopolis.training.personal.items.ActiveExerciseItem

class ActiveExerciseViewHolder(
    itemView: View
) : BaseViewHolder<ActiveExerciseItem>(itemView) {

    private var title: TextView = itemView.parameter
    private var value: EditText = itemView.parameter_goal

    override fun bind(item: ActiveExerciseItem) {
        title.text = item.title
        value.setText(item.value.toString())
    }
}