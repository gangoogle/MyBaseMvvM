package com.example.mymvvmproject.viewmodel.state

import androidx.databinding.ObservableField
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.callback.databind.StringObservableField
import me.hgj.jetpackmvvm.callback.livedata.StringLiveData

/**
 *  @author zgyi
 *  @date 2020/7/23
 *  @Description:
 */

class LoginViewModel : BaseViewModel() {

    //用户名
    var userName = StringLiveData()

    //密码
    var password = StringObservableField()


}