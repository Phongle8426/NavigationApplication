package com.example.navigationapplication.data

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/*
///
/// Project: NavigationApplication
/// Created by pc on 08/20/2021.
///
*/class AccountViewModelFactory(private val application: Application):
ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AccountViewModel::class.java)){
            return AccountViewModel(application) as T
        }
        throw NotImplementedError("No View Model")
    }
}