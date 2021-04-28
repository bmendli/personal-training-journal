package ru.ok.technopolis.training.personal.utils.recycler.adapters

import androidx.annotation.LayoutRes
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.items.ShortWorkoutItem
import ru.ok.technopolis.training.personal.viewholders.BaseViewHolder
import ru.ok.technopolis.training.personal.viewholders.ShortWorkoutViewHolder
import kotlin.reflect.KClass

class ShortWorkoutListAdapter (
        holderType: KClass<out ShortWorkoutViewHolder>,
        @LayoutRes layoutId: Int,
        dataSource: ItemsList<ShortWorkoutItem>,
        onClick: (ShortWorkoutItem) -> Unit = {},
        private val onStart: (ShortWorkoutItem) -> Unit = {}
) : BaseListAdapter<ShortWorkoutItem>(holderType, layoutId, dataSource, onClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<ShortWorkoutItem>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = data[position]
        (holder as ShortWorkoutViewHolder).setOnStartClickListener {
            onStart.invoke(item)
        }
    }
}