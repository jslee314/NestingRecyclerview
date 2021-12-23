package com.jslee.nestingrecyclerview.ui.home

import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jslee.nestingrecyclerview.databinding.ItemFirstListBinding

class MenuAdapter()
    : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var menuList = emptyList<String>()

    fun replaceList(newList: List<String>) {
        this.menuList = newList
        notifyDataSetChanged() //어댑터의 데이터가 변했다는 notify를 날린다
    }


    class MenuViewHolder(var binding:ItemFirstListBinding):  RecyclerView.ViewHolder(binding.root) {
        fun bind(menuItem : String){
            binding.menuTextView.text = menuItem
            binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFirstListBinding.inflate(layoutInflater, parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuItem = menuList[position]
        holder.bind(menuItem)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }
}