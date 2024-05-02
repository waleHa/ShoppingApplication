package com.example.shoppingapplication.ui.profile

import androidx.lifecycle.ViewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppingapplication.domain.model.User
import com.example.shoppingapplication.domain.model.Constants.userHardCoded

class ProfileViewModel : ViewModel() {
    private val _user = MutableLiveData<User>(userHardCoded)


    val user: LiveData<User> = _user
}
