package com.example.mymvvmproject.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.blankj.utilcode.util.LogUtils
import com.example.mymvvmproject.R
import com.example.mymvvmproject.api.base.BaseFragment
import com.example.mymvvmproject.api.base.BaseProxyClick
import com.example.mymvvmproject.api.data.args.LoginFgmArgs
import com.example.mymvvmproject.api.event.EventViewModel
import com.example.mymvvmproject.databinding.FragmentMainBinding
import com.example.mymvvmproject.viewmodel.state.MainViewModel
import me.hgj.jetpackmvvm.demo.app.ext.buildArgsBundle
import me.hgj.jetpackmvvm.ext.getAppViewModel
import me.hgj.jetpackmvvm.ext.nav
import me.hgj.jetpackmvvm.ext.navigateAction
import me.hgj.jetpackmvvm.ext.util.showLog

/**
 * @author zgyi
 * @date 2020/7/24
 * @Description: 首页
 */
class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>() {
    private val eventModel: EventViewModel by lazy { getAppViewModel<EventViewModel>() }

    override fun layoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.click = ProxyClick()
    }


    override fun createObserver() {
        super.createObserver()
        eventModel.onSendTextTestEvent.observe(this, Observer { t ->
            LogUtils.d("onSendTextTestEvent:$t")
        })
    }

    inner class ProxyClick() : BaseProxyClick() {


        /**
         * 跳转到登录页
         */
        fun onJumpToLoginPage() {
            nav().navigateAction(
                R.id.action_mainFragment_to_loginFragment,
                buildArgsBundle(LoginFgmArgs(2))
            )
        }


    }
}