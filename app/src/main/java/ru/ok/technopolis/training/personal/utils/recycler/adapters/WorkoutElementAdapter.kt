package ru.ok.technopolis.training.personal.utils.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_workout_element.view.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.utils.recycler.elements.WorkoutElement

class WorkoutElementAdapter(private val elements: List<WorkoutElement>, private val onClick: ((WorkoutElement) -> Unit))
    : RecyclerView.Adapter<WorkoutElementAdapter.WorkoutElementHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutElementHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_workout_element, parent, false)
        return WorkoutElementHolder(view) {
            onClick.invoke(it)
        }
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: WorkoutElementHolder, position: Int) {
        holder.bind(elements[position])
    }

    class WorkoutElementHolder(itemView: View, private val onClick: (WorkoutElement) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private var icon: ImageView = itemView.icon
        private var title: TextView = itemView.title
        private var description: TextView = itemView.description

        fun bind(element: WorkoutElement) {
            icon.setImageResource(element.iconId)
            title.text = element.title
            description.text = element.description
            itemView.setOnClickListener { onClick.invoke(element) }
        }
    }
}
