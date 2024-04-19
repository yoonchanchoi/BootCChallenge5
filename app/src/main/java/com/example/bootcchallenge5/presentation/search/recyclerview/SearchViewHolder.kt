package com.example.bootcchallenge5.presentation.search.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bootcchallenge5.R
import com.example.bootcchallenge5.databinding.ItemSearchBinding
import com.example.bootcchallenge5.presentation.search.model.ImageDocumentEntity

class SearchViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)

) {

    private val binding = ItemSearchBinding.bind(itemView)

    fun bind(imageDocumentEntity: ImageDocumentEntity) {

        binding.tv.text = imageDocumentEntity.displaySitename
        Glide.with(itemView.context)
            .load(imageDocumentEntity.imageUrl)
            .fitCenter()
            .into(binding.iv)
    }



}
