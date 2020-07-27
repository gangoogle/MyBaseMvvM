package com.example.mymvvmproject.ui.activity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.blankj.utilcode.util.ToastUtils
import com.example.mymvvmproject.R
import com.example.mymvvmproject.api.base.BaseActivity
import com.example.mymvvmproject.databinding.ActivityMainBinding
import com.example.mymvvmproject.viewmodel.request.LoginRequestViewModel
import com.example.mymvvmproject.viewmodel.state.LoginViewModel
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.demo.app.ext.showMessage
import me.hgj.jetpackmvvm.ext.parseState

/**
 * 首页
 */
class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    var exitTime = 0L

    override fun layoutId() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val nav = Navigation.findNavController(this@MainActivity, R.id.host_fragment)
                if (nav.currentDestination != null && nav.currentDestination!!.id != R.id.mainFragment) {
                    //如果当前界面不是主页，那么直接调用返回即可
                    nav.navigateUp()
                } else {
                    //是主页
                    if (System.currentTimeMillis() - exitTime > 2000) {
                        ToastUtils.showShort("再按一次退出程序")
                        exitTime = System.currentTimeMillis()
                    } else {
                        finish()
                    }
                }
            }
        })
    }




    override fun createObserver() {
        super.createObserver()

    }


}