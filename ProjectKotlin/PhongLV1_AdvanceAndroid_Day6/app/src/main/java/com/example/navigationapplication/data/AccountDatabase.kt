package com.example.navigationapplication.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

/*
///
/// Project: NavigationApplication
/// Created by pc on 08/20/2021.
///
*/
@Database(entities = [AccountModel::class],version = 1)
abstract class AccountDatabase: RoomDatabase() {
    abstract fun accountDao(): IAccountDao

        companion object{
        @Volatile
        private var INSTANCE:  AccountDatabase? = null
        fun getInstance(context: Context): AccountDatabase {
            return INSTANCE?: synchronized(this){
                INSTANCE?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }
        }

        fun buildDatabase(context: Context): AccountDatabase{
            return Room.databaseBuilder(context.applicationContext,
                AccountDatabase::class.java,
                "account_db").build()
        }
    }
}