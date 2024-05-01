package com.example.shoppingapplication.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapplication.R
import com.example.shoppingapplication.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CategoryAdapter { categoryId ->
            // Navigate without Safe Args
            navigateToShoppingList(categoryId)
        }

        binding.recyclerViewCategories.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewCategories.adapter = adapter


        viewModel.categories.observe(viewLifecycleOwner) { categories ->
            adapter.submitList(categories)
        }
    }

    private fun navigateToShoppingList(categoryId: Int) {
        val bundle = Bundle().apply {
            putInt("categoryId", categoryId)
        }
        findNavController().navigate(R.id.action_nav_category_to_nav_shopping_list, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
