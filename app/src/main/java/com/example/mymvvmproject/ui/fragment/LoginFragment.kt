package com.example.mymvvmproject.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.example.mymvvmproject.R
import com.example.mymvvmproject.api.base.BaseFragment
import com.example.mymvvmproject.api.base.BaseProxyClick
import com.example.mymvvmproject.api.data.args.LoginFgmArgs
import com.example.mymvvmproject.api.event.EventViewModel
import com.example.mymvvmproject.databinding.FragmentLoginBinding
import com.example.mymvvmproject.viewmodel.request.LoginRequestViewModel
import com.example.mymvvmproject.viewmodel.state.LoginViewModel
import me.hgj.jetpackmvvm.demo.app.ext.getArgsBundle
import me.hgj.jetpackmvvm.demo.app.ext.showMessage
import me.hgj.jetpackmvvm.ext.getAppViewModel
import me.hgj.jetpackmvvm.ext.nav
import me.hgj.jetpackmvvm.ext.parseState

/**
 *  @author zgyi
 *  @date 2020/7/24
 *  @Description:
 */

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {
    private val requestMainViewModel: LoginRequestViewModel by viewModels()
    private val eventModel: EventViewModel by lazy { getAppViewModel<EventViewModel>() }
    private val loginArgs: LoginFgmArgs? by lazy { getDataArgs<LoginFgmArgs>() }

    override fun layoutId(): Int {
        return R.layout.fragment_login
    }


    override fun initView(savedInstanceState: Bundle?) {
        LogUtils.d("loginArgs:" + loginArgs?.type)
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()
    }


    override fun createObserver() {
        super.createObserver()
        requestMainViewModel.loginResult.observe(this, Observer { resultState ->
            parseState(resultState, {
                showMessage("登陆成功")
            }, {
                showMessage(it.errorMsg)
            })
        })

    }

    inner class ProxyClick : BaseProxyClick() {

        override fun getView(): View? {
            return view
        }

        fun onLogin() {
            eventModel.onSendTextTestEvent.value = false
            if (mViewModel.password.get().length < 6) {
                ToastUtils.showLong("密码不能小于6位")
                return
            }
            requestMainViewModel.doLogin(mViewModel.userName.value, mViewModel.password.get())
        }

    }
}