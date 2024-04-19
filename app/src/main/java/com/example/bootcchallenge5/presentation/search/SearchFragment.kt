package com.example.bootcchallenge5.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bootcchallenge5.databinding.FragmentSearchBinding
import com.example.bootcchallenge5.presentation.MainViewModel
import com.example.bootcchallenge5.presentation.search.recyclerview.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val searchAdapter: SearchAdapter by lazy {
        SearchAdapter()
    }
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSearchAdapter()
        setupData()
        setupObserve()
    }


    private fun setupData() {
        mainViewModel.requestImages()
    }

    private fun setupObserve() {
        mainViewModel.imageDocumentEntities.observe(viewLifecycleOwner){
            searchAdapter.submitList(it)
        }
    }

    private fun setSearchAdapter(){
        val searchManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rv.apply {
            layoutManager = searchManager
            adapter = searchAdapter
        }
    }
}