package ru.ok.technopolis.training.personal.viewholders

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import kotlinx.android.synthetic.main.item_exercise_element.view.*
import ru.ok.technopolis.training.personal.items.Parameter

class ExerciseElementViewHolder(
    itemView: View
) : BaseViewHolder<Parameter>(itemView) {

    private var title: EditText = itemView.title
    private var value: EditText = itemView.value
    private var units: Spinner = itemView.units
    private var inputType: Spinner = itemView.input_type
    private var delete: ImageView = itemView.delete_parameter_button

    override fun bind(item: Parameter) {
        title.setText(item.title)
        value.setText(item.value.toString())
        units.setSelection(item.unitId)
        inputType.setSelection(item.inputTypeId)
    }

    fun setClickListener(onDeleteClick: (View) -> Unit) {
        delete.setOnClickListener(onDeleteClick)
    }
}