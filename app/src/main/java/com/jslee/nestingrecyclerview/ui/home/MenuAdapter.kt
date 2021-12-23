package com.jslee.nestingrecyclerview.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jslee.nestingrecyclerview.data.MenuData
import com.jslee.nestingrecyclerview.databinding.ItemFirstListBinding

class MenuAdapter(private val onClickListener: OnClickListener)
    : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var menuList = emptyList<MenuData>()
    fun replaceList(newList: List<MenuData>) {
        this.menuList = newList
        notifyDataSetChanged() //어댑터의 데이터가 변했다는 notify를 날린다
    }


    class MenuViewHolder(var binding:ItemFirstListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(menuItem : MenuData, listener: View.OnClickListener){
            binding.menuTextView.text = menuItem.menuTitle

            val childMenuAdapter = ChildMenuAdapter(ChildMenuAdapter.OnClickListener{
                val clickedItem = it
            })

            childMenuAdapter.replaceList(menuItem.subMenuTitles)

            binding.childRecyclerView.adapter = childMenuAdapter
            binding.childRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)

            itemView.setOnClickListener(listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFirstListBinding.inflate(layoutInflater, parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(menuViewHolder: MenuViewHolder, position: Int) {
        val menuItem = menuList[position]

        val listener = View.OnClickListener { it ->
            onClickListener.onClick(menuItem)
        }
        menuViewHolder.bind(menuItem, listener)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    class OnClickListener(val clickListener: (clickedItem: MenuData) -> Unit) {
        fun onClick(item: MenuData) = clickListener(item)
    }
}