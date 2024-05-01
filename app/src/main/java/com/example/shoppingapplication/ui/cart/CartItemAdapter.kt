package com.example.shoppingapplication.ui.cart

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.LOG
import com.example.shoppingapplication.databinding.ItemCartBinding
import com.example.shoppingapplication.domain.model.CartItem

class CartItemAdapter(private val increaseQuantity: (CartItem) -> Unit) :
    ListAdapter<CartItem, CartItemAdapter.CartViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = getItem(position)
        holder.bind(cartItem)
        holder.binding.imageButton.setOnClickListener {
            increaseQuantity(cartItem)
        }
    }

    class CartViewHolder(internal var binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cartItem: CartItem) {
            // Bind the data with View
            binding.textViewCategoryName.text = cartItem.name
            binding.textViewCategoryDescription.text = "Quantity: ${cartItem.quantity}"
            val MYTAG = "TAG: CartItemAdapter"
            Log.i(MYTAG,cartItem.url)
            // Load image using Glide
            Glide.with(binding.root.context)
                .load(cartItem.url)
                .into(binding.imageViewProfile)
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<CartItem>() {
            override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
