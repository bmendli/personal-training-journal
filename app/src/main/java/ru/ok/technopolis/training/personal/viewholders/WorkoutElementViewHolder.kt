package ru.ok.technopolis.training.personal.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_workout_element.view.*
import ru.ok.technopolis.training.personal.items.WorkoutItem

class WorkoutElementViewHolder(
    itemView: View
) : BaseViewHolder<WorkoutItem>(itemView) {

    private var icon: ImageView = itemView.icon
    private var title: TextView = itemView.title
    private var description: TextView = itemView.description
    private var delete: ImageView = itemView.delete_parameter_button

    override fun bind(item: WorkoutItem) {
        icon.setImageResource(item.iconId)
        title.text = item.title
        description.text = item.description
    }

    fun setClickListener(onDeleteClick: (View) -> Unit) {
        delete.setOnClickListener(onDeleteClick)
    }
}