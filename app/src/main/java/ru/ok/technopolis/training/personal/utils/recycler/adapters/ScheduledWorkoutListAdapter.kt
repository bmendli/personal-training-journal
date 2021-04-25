package ru.ok.technopolis.training.personal.utils.recycler.adapters

import androidx.annotation.LayoutRes
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.items.ScheduledWorkoutItem
import ru.ok.technopolis.training.personal.viewholders.BaseViewHolder
import ru.ok.technopolis.training.personal.viewholders.ScheduledWorkoutViewHolder
import kotlin.reflect.KClass

class ScheduledWorkoutListAdapter(
        holderType: KClass<out ScheduledWorkoutViewHolder>,
        @LayoutRes layoutId: Int,
        dataSource: ItemsList<ScheduledWorkoutItem>,
        onClick: (ScheduledWorkoutItem) -> Unit = {},
        private val onStart: (ScheduledWorkoutItem) -> Unit = {}
) : BaseListAdapter<ScheduledWorkoutItem>(holderType, layoutId, dataSource, onClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<ScheduledWorkoutItem>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = data[position]
        (holder as ScheduledWorkoutViewHolder).setOnStartClickListener {
            onStart.invoke(item)
        }
    }
}