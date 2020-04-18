package ru.ok.technopolis.training.personal.utils.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.viewholders.BaseViewHolder
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

class BaseListAdapter<Item>(
        private val holderType: KClass<out BaseViewHolder<Item>>,
        private val data: List<Item>,
        private val onClick: (Item) -> Unit = {}
) : RecyclerView.Adapter<BaseViewHolder<Item>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item> {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(
                        R.layout.item_workout_element,
                        parent,
                        false
                )
        return holderType.primaryConstructor?.call(view)
                ?: throw NoSuchMethodException("No constructor with parameter of type View")
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BaseViewHolder<Item>, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onClick.invoke(item) }
    }
}