package ru.ok.technopolis.training.personal.utils.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.disposables.CompositeDisposable
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.viewholders.BaseViewHolder
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

open class BaseListAdapter<Item>(
    private val holderType: KClass<out BaseViewHolder<Item>>,
    @LayoutRes private val layoutId: Int,
    private val dataSource: ItemsList<Item>,
    private val onClick: (Item) -> Unit = {}
) : RecyclerView.Adapter<BaseViewHolder<Item>>() {

    internal var data = listOf<Item>()

    private var dataSourceSubscription: CompositeDisposable? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        data = dataSource.items
        dataSourceSubscription?.addAll(
            dataSource.addingSubject().subscribe {
                notifyItemInserted(0)
            },
            dataSource.removingSubject().subscribe {
                notifyItemRemoved(it)
            },
            dataSource.updatingSubject().subscribe {
                notifyItemRemoved(it)
            }
        )
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        dataSourceSubscription?.dispose()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item> {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(
                layoutId,
                parent,
                false
            )
        return holderType.primaryConstructor?.call(view)
            ?: throw NoSuchMethodException("No constructor with parameter of type View")
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BaseViewHolder<Item>, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onClick.invoke(item) }
    }
}