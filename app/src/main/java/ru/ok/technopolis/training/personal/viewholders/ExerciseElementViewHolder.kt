package ru.ok.technopolis.training.personal.viewholders

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
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
        units.setSelection(item.parameter.measureUnitId.toInt() - 1)
        inputType.setSelection(item.parameter.parameterTypeId.toInt() - 1)

        title.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s != null && s.isNotEmpty()) {
                    item.parameter.name = s.toString()
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s != null && s.isNotEmpty()) {
                    val newValue: Float? = s.toString().toFloatOrNull()
                    if (newValue != null) {
                        item.parameter.value = newValue
                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        units.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                item.parameter.measureUnitId = position.toLong() + 1
            }
        }
        inputType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                item.parameter.parameterTypeId = position.toLong() + 1
            }
        }
    }

    fun setClickListener(onDeleteClick: (View) -> Unit) {
        delete.setOnClickListener(onDeleteClick)
    }
}