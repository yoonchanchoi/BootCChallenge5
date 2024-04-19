package com.example.bootcchallenge5.presentation.search.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.bootcchallenge5.presentation.search.model.ImageDocumentEntity

class SearchAdapter : ListAdapter<ImageDocumentEntity, SearchViewHolder>(SearchDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder = SearchViewHolder(parent = parent)

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}