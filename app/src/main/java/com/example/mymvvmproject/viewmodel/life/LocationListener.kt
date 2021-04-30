package com.example.mymvvmproject.viewmodel.life

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LocationListener : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAddMap() {
        Log.d("yzg", "life-addMap")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onRegText() {
        Log.d("yzg", "life-reg-text")
    }
}