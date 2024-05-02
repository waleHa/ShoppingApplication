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

class ShoppingItemAdapter (private val onShoppingItemClicked: (ShoppingItem) -> Unit):
    ListAdapter<ShoppingItem, ShoppingItemAdapter.ShoppingItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val binding =
            ItemShoppingListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val list = getItem(position)
        holder.bind(list)
        holder.itemView.setOnClickListener {
            onShoppingItemClicked(list) // Pass the category ID to the fragment
        }
    }

    class ShoppingItemViewHolder(private val binding: ItemShoppingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ShoppingItem) {
            binding.textViewProductName.text = item.name
            binding.textViewPrice.text = "Price:${item.price}$"
            binding.textViewRating.text =
                "⭐: ${item.ratingModel?.rateAverage}\nCount: ${item.ratingModel?.count}"
            Glide.with(binding.imageViewProduct.context)
                .load(item.url)
                .centerCrop()
                .placeholder(R.drawable.icon_category)
                .into(binding.imageViewProduct)


        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<ShoppingItem>() {
            override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean =
                oldItem == newItem
        }
    }
}
