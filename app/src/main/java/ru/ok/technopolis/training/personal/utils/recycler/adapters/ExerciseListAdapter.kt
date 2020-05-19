package ru.ok.technopolis.training.personal.utils.recycler.adapters

import androidx.annotation.LayoutRes
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.items.WorkoutItem
import ru.ok.technopolis.training.personal.viewholders.BaseViewHolder
import ru.ok.technopolis.training.personal.viewholders.WorkoutElementViewHolder
import kotlin.reflect.KClass

class ExerciseListAdapter(
        holderType: KClass<out WorkoutElementViewHolder>,
        @LayoutRes layoutId: Int,
        dataSource: ItemsList<WorkoutItem>,
        onClick: (WorkoutItem) -> Unit = {},
        private val onDeleteExerciseClick: (WorkoutItem) -> Unit = {}
) : BaseListAdapter<WorkoutItem>(holderType, layoutId, dataSource, onClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<WorkoutItem>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = data[position]
        (holder as WorkoutElementViewHolder).setClickListener { onDeleteExerciseClick.invoke(item) }
    }
}
