package ru.ok.technopolis.training.personal.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class BaseViewHolder<Item>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: Item)
}