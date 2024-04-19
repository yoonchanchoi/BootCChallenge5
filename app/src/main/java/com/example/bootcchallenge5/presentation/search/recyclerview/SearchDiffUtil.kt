package com.example.bootcchallenge5.presentation.search.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.bootcchallenge5.presentation.search.model.ImageDocumentEntity

class SearchDiffUtil : DiffUtil.ItemCallback<ImageDocumentEntity>() {

    override fun areItemsTheSame(oldItem: ImageDocumentEntity, newItem: ImageDocumentEntity): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: ImageDocumentEntity, newItem: ImageDocumentEntity): Boolean =
        oldItem == newItem
}
