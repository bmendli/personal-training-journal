package ru.ok.technopolis.training.personal.viewholders

import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_workout.view.*
import kotlinx.android.synthetic.main.item_workout_element.view.title
import ru.ok.technopolis.training.personal.items.Workout

class WorkoutViewHolder(
    itemView: View
) : BaseViewHolder<Workout>(itemView) {

    private var time: TextView = itemView.time
    private var title: TextView = itemView.title

    override fun bind(item: Workout) {
        time.text = item.time
        title.text = item.title
    }
}