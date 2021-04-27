package ru.ok.technopolis.training.personal.utils.recycler.listeners

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InfinityScrollListener(private val pushDay: (Boolean) -> Unit, private val daysList: List<Any>): RecyclerView.OnScrollListener() {

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
                val initialSize = daysList.size
                pushDay(true)
                val updatedSize = daysList.size
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
}