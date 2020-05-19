package ru.ok.technopolis.training.personal.items

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class ItemsList<Item>(val items: MutableList<Item>) {

//    class ModifiedItem<Item>(val index: Int, val item: Item)

    private val addingSubject: PublishSubject<Item> = PublishSubject.create()
    private val removingSubject: PublishSubject<Int> = PublishSubject.create()
    private val updatingSubject: PublishSubject<Int> = PublishSubject.create()

    fun addingSubject(): Observable<Item> {
        return addingSubject
    }

    fun removingSubject(): Observable<Int> {
        return removingSubject
    }

    fun updatingSubject(): Observable<Int> {
        return updatingSubject
    }

    fun add(item: Item) {
        items.add(0, item)
        addingSubject.onNext(item)
    }

    fun remove(item: Item) {
        val ind = items.indexOf(item)
        items.remove(item)
        removingSubject.onNext(ind)
    }

    fun update(position: Int, item: Item) {
        items[position] = item
        updatingSubject.onNext(position)
    }

    fun size(): Int {
        return items.size
    }

}