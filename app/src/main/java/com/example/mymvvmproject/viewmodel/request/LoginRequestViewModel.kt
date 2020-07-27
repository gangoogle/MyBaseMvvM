package com.example.mymvvmproject.viewmodel.request

import androidx.lifecycle.MutableLiveData
import com.example.mymvvmproject.api.data.model.UserInfo
import com.example.mymvvmproject.api.network.apiService
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.request
import me.hgj.jetpackmvvm.state.ResultState

/**
 *  @author zgyi
 *  @date 2020/7/23
 *  @Description:
 */

class LoginRequestViewModel : BaseViewModel() {

    var loginResult = MutableLiveData<ResultState<UserInfo>>()

    fun doLogin(userName: String, password: String) {
        request(
            { apiService.login(userName, password) },
            loginResult, true, "登陆中"
        )
    }


}