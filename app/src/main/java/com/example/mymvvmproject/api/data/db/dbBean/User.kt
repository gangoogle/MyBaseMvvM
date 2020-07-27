package com.example.mymvvmproject.api.data.db.dbBean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *  @author zgyi
 *  @date 2020/7/21
 *  @Description:
 */
@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "firstname") val firstName: String?,
    @ColumnInfo(name = "lastname") val lastName: String?
)


 