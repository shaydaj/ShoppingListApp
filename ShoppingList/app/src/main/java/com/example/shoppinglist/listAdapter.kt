package com.example.shoppinglist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class listAdapter (
    private val items: MutableList<list>
) : RecyclerView.Adapter<listAdapter.ItemViewHolder> {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
          LayoutInflater.from(parent.context).inflate (
              R.layout.item_shopping,
              parent,
              false
          )
      )
    }

    fun addItem(list: list) {
        items.add(list)
        notifyItemInserted(items.size - 1)
    }

    fun deleteDoneItem() {
        items.removeAll{list -> list.isChecked}
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvItemTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvItemTitle.paintFlags = tvItemTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvItemTitle.paintFlags = tvItemTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val curItem = items[position]
        holder.itemView.apply {
            tvShoppingTitle.text = curItem.title
            cbComplete.isChecked = curItem.isChecked
            toggleStrikeThrough(tvShoppingTitle, curItem.isChecked)
            cbComplete.setOnCheckedChangeListener {_, isChecked ->
                toggleStrikeThrough(tvShoppingTitle, isChecked)
                curItem.isChecked = !curItem.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

