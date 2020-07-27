package com.example.mymvvmproject.api.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mymvvmproject.api.api.MyApp
import com.example.mymvvmproject.api.data.db.dbBean.User
import com.example.mymvvmproject.api.data.db.dbDao.UserDao

/**
 *   @auther : zgyi
 *   time   : 2020/07/23
 *   room数据库
 *   单例
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userData(): UserDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase().also { instance = it }
            }
        }

        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(): AppDatabase {
            return Room.databaseBuilder(MyApp.instance, AppDatabase::class.java, "appDatabase")
                .build()
        }
    }
}