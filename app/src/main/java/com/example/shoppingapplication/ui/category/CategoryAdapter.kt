package com.example.shoppingapplication.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoppingapplication.databinding.ItemCategoryBinding
import com.example.shoppingapplication.domain.model.Category

class CategoryAdapter(private val onCategoryClicked: (Int) -> Unit) : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
        holder.itemView.setOnClickListener {
            onCategoryClicked(category.id) // Pass the category ID to the fragment
        }
    }

    class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.textViewCategoryName.text = category.name
            binding.textViewCategoryDescription.text = category.description
            Glide.with(binding.root.context)
                .load(category.url)
                .into(binding.imageViewCategory)
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem == newItem
        }
    }
}
