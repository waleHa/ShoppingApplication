package com.example.shoppingapplication.ui.shoppinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapplication.R
import com.example.shoppingapplication.databinding.FragmentShoppingListBinding
import com.example.shoppingapplication.domain.model.Constants
import com.example.shoppingapplication.domain.model.ShoppingItem
import com.example.shoppingapplication.ui.category.CategoryAdapter

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
        val adapter = ShoppingItemAdapter { item ->
            // Navigate without Safe Args
            navigateToDetails(item)
        }

        binding.recyclerViewShoppingList.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewShoppingList.adapter = adapter

        val categoryId = arguments?.getString("categoryId", "-1")
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

    private fun navigateToDetails(item: ShoppingItem) {
        val bundle = Bundle().apply {
            putParcelable(Constants.shoppingDetailedKey,item)
        }
//        val bundle = Bundle().putParcelable(Constants.shoppingDetailedKey,item)
        findNavController().navigate(R.id.action_nav_shopping_list_to_detailedShoppingFragment,bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
