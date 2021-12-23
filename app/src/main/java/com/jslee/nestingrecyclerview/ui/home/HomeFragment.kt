package com.jslee.nestingrecyclerview.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jslee.nestingrecyclerview.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!! // This property is only valid between onCreateView and onDestroyView.
    private lateinit var adapter: MenuAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setViews()
        setObserve()

        return binding.root
    }

    private fun setViews(){
        adapter = MenuAdapter( MenuAdapter.OnClickListener{
            val clickedItem = it
        })
        adapter.replaceList(viewModel.fistList)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

    }

    private fun setObserve(){
//        viewModel.secondListOfFist.observe(viewLifecycleOwner, Observer {
//            binding.recyclerView
//        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}