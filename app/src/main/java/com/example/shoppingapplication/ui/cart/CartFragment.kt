package com.example.shoppingapplication.ui.cart


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapplication.databinding.FragmentCartBinding


class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    // Lazy initialization of the ViewModel
    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CartItemAdapter(cartViewModel::increaseQuantity)
        binding.recyclerViewCartItems.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewCartItems.adapter = adapter

        // Observe the LiveData from the ViewModel and update the UI
        cartViewModel.cartItems.observe(viewLifecycleOwner) { items ->
            adapter.submitList(items)  // Pass the items to the adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
