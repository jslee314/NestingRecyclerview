package com.jslee.nestingrecyclerview.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jslee.nestingrecyclerview.databinding.ItemFirstListBinding
import com.jslee.nestingrecyclerview.databinding.ItemSecondListBinding

class ChildMenuAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<ChildMenuAdapter.ChildMenuViewHolder>() {
      val list = emptyList<String>()

    class ChildMenuViewHolder(private val binding: ItemSecondListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item :String, listener : View.OnClickListener){
            binding.textView.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildMenuViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSecondListBinding.inflate(layoutInflater)
        return ChildMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildMenuViewHolder, position: Int) {
        val item = list[position]
        val listener = View.OnClickListener { it ->
            onClickListener.onClick(item)
        }
        holder.bind(item, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class OnClickListener(val clickListener: (clickedItem: String) -> Unit) {
        fun onClick(item: String) = clickListener(item)
    }
}