package com.example.shoppingapplication.ui.profile

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shoppingapplication.R
import com.example.shoppingapplication.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel.user.observe(viewLifecycleOwner) { user ->
            binding.apply {
                imageViewProfile.setImageResource(R.drawable.icon_profile)  // Assuming you have a placeholder
                textViewUserName.text = user.userName
                textName.text = user.fullName
                textLocation.text = user.location
                textJoinDate.text = user.joinDate
                textDescription.text = user.description
                textWebsite.text = user.websiteUrl
                textEmail.text = user.email
                textPhone.text = user.phoneNumber
                textJoined.text = user.joinDate
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}