package ru.ok.technopolis.training.personal.items

class DaysList(items: MutableList<DayItem>): ItemsList<DayItem>(items) {

    var selectedItem: DayItem? = null

    fun select(item: DayItem) {
        selectedItem?.let {
            val oldPos = items.indexOf(it)
            it.isChosen = false
            update(oldPos, it)
        }
        val position = items.indexOf(item)
        item.isChosen = true
        update(position, item)
        selectedItem = item
    }

}