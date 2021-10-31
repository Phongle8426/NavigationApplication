package com.example.navigationapplication.data

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey


/*
///
/// Project: NavigationApplication
/// Created by pc on 08/20/2021.
///
*/
@Entity(tableName = "account")
data class AccountModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val id: Int = 0,
    @ColumnInfo val phone: String ,
    @ColumnInfo val password: String,

)