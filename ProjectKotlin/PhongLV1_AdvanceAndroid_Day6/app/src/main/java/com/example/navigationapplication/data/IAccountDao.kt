package com.example.navigationapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/*
///
/// Project: NavigationApplication
/// Created by pc on 08/20/2021.
///
*/
@Dao
interface IAccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAccount(acc: AccountModel)

    @Query("SELECT * FROM account WHERE phone = :phone AND password = :password")
    fun getAccount(phone: String, password: String): LiveData<AccountModel>
}