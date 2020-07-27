package com.example.mymvvmproject.api.api

import android.app.Application
import androidx.multidex.MultiDex
import com.blankj.utilcode.util.LogUtils
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import com.tencent.mmkv.MMKV
import me.hgj.jetpackmvvm.base.BaseApp
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.EmptyCallback
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.ErrorCallback
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.LoadingCallback
import me.hgj.jetpackmvvm.ext.lifecycle.KtxLifeCycleCallBack

/**
 *  @author zgyi
 *  @date 2020/7/23
 *  @Description: 主application
 */

class MyApp : BaseApp {

    constructor() : super()

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        MMKV.initialize(this)
        //全局注册
        MultiDex.install(this)
        //注册全局activity生命周期回调
        this.registerActivityLifecycleCallbacks(KtxLifeCycleCallBack())
        //load sir
        //界面加载管理 初始化
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(ErrorCallback())//错误
            .addCallback(EmptyCallback())//空
            .setDefaultCallback(SuccessCallback::class.java)//设置默认加载状态页
            .commit()

        //日志
        LogUtils.getConfig().apply {
            this.isLogSwitch = !isOnLine
            this.globalTag = "yzg"
        }


    }
}