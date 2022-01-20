package com.leandroid.system.teammanagement.ui.view.rank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandroid.system.teammanagement.ui.view.rank.adapter.TableItemAdapter
import com.leandroid.system.teammanagement.databinding.FragmentRankBinding

class RankFragment : Fragment() {
    private lateinit var binding: FragmentRankBinding
    private lateinit var viewModel: RankViewModel
    private val adapter = TableItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRankBinding.inflate(inflater, container, false)
        return binding.root

    }
    private fun initObserverViewModel(){
        viewModel.tableItems.observe(this, Observer { items ->
            adapter.setItems(items)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(RankViewModel::class.java)
        initObserverViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.rvTableRank.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTableRank.adapter = adapter
    }

}

