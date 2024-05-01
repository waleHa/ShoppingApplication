package com.example.shoppingapplication.ui.shoppinglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoppingapplication.R
import com.example.shoppingapplication.databinding.ItemShoppingListBinding
import com.example.shoppingapplication.domain.model.ShoppingItem

class ShoppingItemAdapter : ListAdapter<ShoppingItem, ShoppingItemAdapter.ShoppingItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val binding = ItemShoppingListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ShoppingItemViewHolder(private val binding: ItemShoppingListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ShoppingItem) {
            binding.textViewProductName.text = item.name
            binding.textViewPrice.text = "${item.price}"
            Glide.with(binding.imageViewProduct.context)
                .load(item.url)
                .placeholder(R.drawable.icon_category)
                .into(binding.imageViewProduct)
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<ShoppingItem>() {
            override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean = oldItem == newItem
        }
    }
}
