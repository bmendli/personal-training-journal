package ru.ok.technopolis.training.personal.utils.recycler.adapters

import androidx.annotation.LayoutRes
import io.reactivex.Observable
import ru.ok.technopolis.training.personal.items.Workout
import ru.ok.technopolis.training.personal.viewholders.BaseViewHolder
import ru.ok.technopolis.training.personal.viewholders.WorkoutViewHolder
import kotlin.reflect.KClass

class CalendarWorkoutListAdapter(
        holderType: KClass<out WorkoutViewHolder>,
        @LayoutRes layoutId: Int,
        dataSource: Observable<List<Workout>>,
        onClick: (Workout) -> Unit = {},
        private val onStartWorkoutClick: (Workout) -> Unit = {},
        private val onDeleteWorkoutClick: (Workout) -> Unit = {}
) : BaseListAdapter<Workout>(holderType, layoutId, dataSource, onClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<Workout>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = data[position]
        (holder as WorkoutViewHolder).setClickListeners(
                { onStartWorkoutClick.invoke(item) },
                { onDeleteWorkoutClick.invoke(item) }
        )
    }
}