package com.example.mymvvmproject.viewmodel.state

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.callback.databind.BooleanObservableField
import me.hgj.jetpackmvvm.callback.databind.IntObservableField
import me.hgj.jetpackmvvm.callback.databind.StringObservableField
import me.hgj.jetpackmvvm.callback.livedata.StringLiveData

class UserListViewModel : BaseViewModel() {

    var userName = StringObservableField()

    var userAge = StringObservableField()

    var isShowCheckBox = object : ObservableInt(userName) {
        override fun get(): Int {
            if (userName.get().length > 10) {
                return View.VISIBLE
            }
            return View.INVISIBLE
        }
    }

}