package me.hgj.jetpackmvvm.demo.app.util

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import com.example.mymvvmproject.api.api.MyApp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


object CacheUtil {
    const val STORE_NAME = "app_store"
    const val KEY_LOGIN = "login"
    const val KEY_APP = "app"
    private val dataStore by lazy {
        MyApp.instance.applicationContext.createDataStore(name = STORE_NAME)
    }


    /**
     * 是否已经登录
     */
    fun isLogin(): Flow<Boolean> {
        val KEY = preferencesKey<Boolean>(KEY_LOGIN)
        val flow = dataStore.data.map { p ->
            p[KEY] ?: false
        }
        return flow
    }


    /**
     * 设置是否已经登录
     */
    suspend fun setIsLogin(isLogin: Boolean) {
        val key = preferencesKey<Boolean>(KEY_LOGIN)
        dataStore.edit { it[key] = isLogin }
    }



}