package ru.ok.technopolis.training.personal.viewholders

import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.item_exercise_element.view.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.db.entity.MeasureUnitEntity
import ru.ok.technopolis.training.personal.db.entity.ParameterTypeEntity
import ru.ok.technopolis.training.personal.db.model.ParameterModel

class ExerciseElementViewHolder(
    itemView: View
) : BaseViewHolder<ParameterModel>(itemView) {

    private var title: EditText = itemView.title
    private var value: EditText = itemView.value
    private var units: Spinner = itemView.units
    private var inputType: Spinner = itemView.input_type
    private var delete: ImageView = itemView.delete_parameter_button

    override fun bind(item: ParameterModel) {
        title.setText(item.parameter.name)
        value.setText(item.parameter.value.toString())
        units.adapter = ArrayAdapter<MeasureUnitEntity>(
            this.itemView.context,
            R.layout.spinner_item,
            item.measureUnitChoices
        )
        inputType.adapter = ArrayAdapter<ParameterTypeEntity>(
            this.itemView.context,
            R.layout.spinner_item,
            item.parameterTypeChoices
        )
        units.setSelection(item.parameter.measureUnitId.toInt())
        inputType.setSelection(item.parameter.parameterTypeId.toInt())
    }

    fun setClickListener(onDeleteClick: (View) -> Unit) {
        delete.setOnClickListener(onDeleteClick)
    }
}