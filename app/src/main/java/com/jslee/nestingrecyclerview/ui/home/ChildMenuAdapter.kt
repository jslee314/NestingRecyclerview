package com.jslee.nestingrecyclerview.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jslee.nestingrecyclerview.data.MenuData
import com.jslee.nestingrecyclerview.databinding.ItemFirstListBinding
import com.jslee.nestingrecyclerview.databinding.ItemSecondListBinding

class ChildMenuAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<ChildMenuAdapter.ChildMenuViewHolder>() {

    private var menuList = emptyList<String>()
    fun replaceList(newList: List<String>) {
        this.menuList = newList
        notifyDataSetChanged() //어댑터의 데이터가 변했다는 notify를 날린다
    }

    class ChildMenuViewHolder(private val binding: ItemSecondListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item :String, listener : View.OnClickListener){
            binding.secondMenu.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildMenuViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSecondListBinding.inflate(layoutInflater)
        return ChildMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildMenuViewHolder, position: Int) {
        val item = menuList[position]
        val listener = View.OnClickListener { it ->
            onClickListener.onClick(item)
        }
        holder.bind(item, listener)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    class OnClickListener(val clickListener: (clickedItem: String) -> Unit) {
        fun onClick(item: String) = clickListener(item)
    }
}