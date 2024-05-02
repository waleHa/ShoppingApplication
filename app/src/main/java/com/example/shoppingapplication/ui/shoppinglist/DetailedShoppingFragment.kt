package com.example.shoppingapplication.ui.shoppinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.shoppingapplication.databinding.FragmentDetailedShoppingBinding
import com.example.shoppingapplication.domain.model.Constants
import com.example.shoppingapplication.domain.model.ShoppingItem
import java.lang.StringBuilder

class DetailedShoppingFragment : Fragment() {
    lateinit var binding: FragmentDetailedShoppingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailedShoppingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arguments?.getParcelable(Constants.shoppingDetailedKey, ShoppingItem::class.java)

            binding.textViewRating.text =  "Rating: ${list?.ratingModel?.rateAverage} ${getStars(list?.ratingModel?.rateAverage?.toInt())}\n\nRaters Count: ${list?.ratingModel?.count}"

        binding.textViewPrice.text = "Price: ${list?.price}$"
        binding.textViewProductDescription.text = "Description: ${list?.descriptionModel}"
        binding.textViewProductName.text = list?.name


        Glide.with(view.context)
            .load(list?.url)
            .into(binding.imageViewProduct)
    }

    fun getStars(num:Int?):String{
        val result = StringBuilder("")
        num?.let {
            for (star in 0 until  num){
                result.append("⭐")
            }
        }
        return result.toString()
    }

}