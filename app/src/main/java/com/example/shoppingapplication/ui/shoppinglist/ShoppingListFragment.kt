package com.example.shoppingapplication.ui.shoppinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapplication.databinding.FragmentShoppingListBinding

class ShoppingListFragment : Fragment() {
    private var _binding: FragmentShoppingListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShoppingListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoppingListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryId = arguments?.getString("categoryId", "-1")
        val adapter = ShoppingItemAdapter()
        binding.recyclerViewShoppingList.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewShoppingList.adapter = adapter

        viewModel.shoppingItems.observe(viewLifecycleOwner) { items ->
            if (categoryId != null) {
                adapter.submitList(items.filter {
                    it.category.equals(categoryId)
                })
            } else {
                adapter.submitList(items)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
