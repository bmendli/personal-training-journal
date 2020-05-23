package ru.ok.technopolis.training.personal.utils.recycler.adapters

import androidx.annotation.LayoutRes
import ru.ok.technopolis.training.personal.db.entity.ExerciseEntity
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.viewholders.BaseViewHolder
import ru.ok.technopolis.training.personal.viewholders.ExerciseViewHolder
import kotlin.reflect.KClass

class ExerciseListAdapter(
    holderType: KClass<out ExerciseViewHolder>,
    @LayoutRes layoutId: Int,
    dataSource: ItemsList<ExerciseEntity>,
    onClick: (ExerciseEntity) -> Unit = {},
    private val onDeleteExerciseClick: (ExerciseEntity) -> Unit = {}
) : BaseListAdapter<ExerciseEntity>(holderType, layoutId, dataSource, onClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<ExerciseEntity>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = data[position]
        (holder as ExerciseViewHolder).setClickListener { onDeleteExerciseClick.invoke(item) }
    }
}
