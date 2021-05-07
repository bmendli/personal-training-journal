package ru.ok.technopolis.training.personal.utils.recycler.adapters

import androidx.annotation.LayoutRes
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.items.ShortExerciseItem
import ru.ok.technopolis.training.personal.viewholders.BaseViewHolder
import ru.ok.technopolis.training.personal.viewholders.ShortExerciseViewHolder
import kotlin.reflect.KClass

class ShortExerciseListAdapter (
        holderType: KClass<out ShortExerciseViewHolder>,
        @LayoutRes layoutId: Int,
        dataSource: ItemsList<ShortExerciseItem>,
        onClick: (ShortExerciseItem) -> Unit = {},
        private val onStart: (ShortExerciseItem) -> Unit = {}
) : BaseListAdapter<ShortExerciseItem>(holderType, layoutId, dataSource, onClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<ShortExerciseItem>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = data[position]
        (holder as ShortExerciseViewHolder).setOnStartClickListener {
            onStart.invoke(item)
        }
    }
}