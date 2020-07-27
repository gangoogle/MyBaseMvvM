package com.example.mymvvmproject.api.data.db.dbDao

import androidx.room.Dao
import androidx.room.Query
import com.example.mymvvmproject.api.data.db.dbBean.User

/**
 *  @author zgyi
 *  @date 2020/7/21
 *  @Description:
 */

@Dao
interface UserDao {

    @Query("select * from user")
    fun getAll(): List<User>

}