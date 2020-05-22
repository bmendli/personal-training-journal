package ru.ok.technopolis.training.personal.utils.recycler.adapters

import androidx.annotation.LayoutRes
import ru.ok.technopolis.training.personal.db.model.ParameterModel
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.viewholders.BaseViewHolder
import ru.ok.technopolis.training.personal.viewholders.ExerciseElementViewHolder
import kotlin.reflect.KClass

class ParameterListAdapter(
    holderType: KClass<out ExerciseElementViewHolder>,
    @LayoutRes layoutId: Int,
    dataSource: ItemsList<ParameterModel>,
    onClick: (ParameterModel) -> Unit = {},
    private val onDeleteParameterClick: (ParameterModel) -> Unit = {}
) : BaseListAdapter<ParameterModel>(holderType, layoutId, dataSource, onClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<ParameterModel>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = data[position]
        (holder as ExerciseElementViewHolder).setClickListener { onDeleteParameterClick.invoke(item) }
    }
}
