package ru.ok.technopolis.training.personal.viewholders

import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.item_active_exercise_element.view.*
import ru.ok.technopolis.training.personal.items.ExerciseItem

class ActiveExerciseViewHolder(
    itemView: View
) : BaseViewHolder<ExerciseItem>(itemView) {

    private var title: TextView = itemView.parameter
    private var value: EditText = itemView.parameter_goal

    override fun bind(item: ExerciseItem) {
        title.text = item.title
        value.setText(item.value.toString())
    }
}