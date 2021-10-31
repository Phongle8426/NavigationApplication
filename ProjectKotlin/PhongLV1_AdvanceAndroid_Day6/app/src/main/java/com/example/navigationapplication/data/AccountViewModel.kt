package com.example.navigationapplication.data

import android.app.Application
import androidx.lifecycle.ViewModel

/*
///
/// Project: NavigationApplication
/// Created by pc on 08/20/2021.
///
*/

class AccountViewModel(private val application: Application): ViewModel() {
    private val accountDao = AccountDatabase.getInstance(application.applicationContext).accountDao()
    fun getAccount(phone: String, pass: String) = accountDao.getAccount(phone,pass)
    fun addAccount(acc: AccountModel){
        accountDao.addAccount(acc)
    }
}