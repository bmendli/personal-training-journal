package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_workout_plan.view.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.items.DayItem
import ru.ok.technopolis.training.personal.items.DaysList
import ru.ok.technopolis.training.personal.items.EventColor
import ru.ok.technopolis.training.personal.utils.recycler.adapters.DayListAdapter
import ru.ok.technopolis.training.personal.viewholders.DayViewHolder
import java.sql.Date
import java.text.DateFormatSymbols
import java.util.*

class WorkoutPlanFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null

    private val calendar: Calendar = Calendar.getInstance()
    private val symbols: DateFormatSymbols = DateFormatSymbols()
    private val dayNames: Array<String> = symbols.shortWeekdays

    private var daysBefore = 0
    private var daysAfter = 0


    private val daysMutableList = mutableListOf<DayItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.days_recycler_view


        calendar.time = Date(System.currentTimeMillis())
        calendar.add(Calendar.DAY_OF_MONTH, -daysBefore)

        for (i in 0..7) {
            pushDay(false)
            pushDay(true)
        }

        val itemsList = DaysList(daysMutableList)

        val dayAdapter = DayListAdapter(
                holderType = DayViewHolder::class,
                layoutId = R.layout.day_item,
                dataSource = itemsList,
                onClick = { dayItem ->
                    itemsList.select(dayItem)
                }
        )

        recyclerView?.adapter = dayAdapter
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView?.layoutManager = linearLayoutManager
        recyclerView?.scrollToPosition(daysBefore - 1)
        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            var previousTotal = 0
            var loading = true
            val visibleThreshold = 10
            var firstVisibleItem = 0
            var visibleItemCount = 0
            var totalItemCount = 0

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dx > 0) {
                    visibleItemCount = recyclerView.childCount
                    totalItemCount = recyclerView.layoutManager!!.itemCount
                    firstVisibleItem = (recyclerView.layoutManager!! as LinearLayoutManager).findFirstVisibleItemPosition()

                    if (loading) {
                        if (totalItemCount > previousTotal) {
                            loading = false
                            previousTotal = totalItemCount
                        }
                    }

                    if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                        val initialSize = daysMutableList.size
                        pushDay(true)
                        val updatedSize = daysMutableList.size
                        recyclerView.post { recyclerView.adapter!!.notifyItemRangeInserted(initialSize, updatedSize) }
                        loading = true
                    }
                } else if (dx < 0) {
                    visibleItemCount = recyclerView.childCount
                    totalItemCount = recyclerView.layoutManager!!.itemCount
                    firstVisibleItem = (recyclerView.layoutManager!! as LinearLayoutManager).findFirstVisibleItemPosition()

                    if (loading) {
                        if (totalItemCount > previousTotal) {
                            loading = false
                            previousTotal = totalItemCount
                        }
                    }

                    if (!loading && firstVisibleItem <= visibleThreshold) {
                        pushDay(false)
                        recyclerView.post { recyclerView.adapter!!.notifyItemInserted(0) }
                        loading = true
                    }
                }
            }
        })
    }

    private fun pushDay(ahead: Boolean) {
        val index = if (ahead) daysMutableList.size else 0
        val dayId = if (ahead) daysAfter++ else ++daysBefore
        calendar.time = Date(System.currentTimeMillis())
        if (ahead) {
            calendar.add(Calendar.DAY_OF_MONTH, dayId)
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, -dayId)
        }
        daysMutableList.add(
                index,
                DayItem(
                        dayId.toString(),
                        calendar.time,
                        dayNames[calendar.get(Calendar.DAY_OF_WEEK)],
                        isChosen = false,
                        isToday = dayId == 0,
                        event = EventColor.GREEN
                )
        )
//        recyclerView?.post { recyclerView?.adapter?.notifyItemInserted(index) }
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_workout_plan
}
