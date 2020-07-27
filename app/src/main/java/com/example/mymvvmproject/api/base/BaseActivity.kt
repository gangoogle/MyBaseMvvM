package com.example.mymvvmproject.api.base

import android.R
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.BarUtils
import com.example.mymvvmproject.api.event.AppViewModel
import com.example.mymvvmproject.api.event.EventViewModel
import com.example.mymvvmproject.api.ext.dismissLoadingExt
import com.example.mymvvmproject.api.ext.showLoadingExt
import me.hgj.jetpackmvvm.base.activity.BaseVmDbActivity
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.demo.app.util.StatusBarUtil
import me.hgj.jetpackmvvm.ext.getAppViewModel
import me.jessyan.autosize.AutoSizeCompat

/**
 *  @author zgyi
 *  @date 2020/7/23
 *  @Description: 基类
 */

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmDbActivity<VM, DB>() {

    val mAppViewModel: AppViewModel by lazy {
        getAppViewModel<AppViewModel>()
    }

    val mEventViewModel: EventViewModel by lazy {
        getAppViewModel<EventViewModel>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (isBaseFullScreen()) {
            fullScreen()
        }
        super.onCreate(savedInstanceState)
        val barColor: Int = setDefaultBarColor()
        if (!isBaseFullScreen()) {
            setStatuBarTransparency()
            if (isStatusBarNoPadding()) {
                StatusBarUtil.setColorNoTranslucent(this, barColor)
            } else {
                addStatusViewWithColor(barColor)
            }
        }
    }


    abstract override fun layoutId(): Int


    abstract override fun initView(savedInstanceState: Bundle?)


    override fun showLoading(message: String) {
        showLoadingExt(message)
    }

    override fun dismissLoading() {
        dismissLoadingExt()
    }

    override fun createObserver() {}


    /**
     * 在任何情况下本来适配正常的布局突然出现适配失效，适配异常等问题，只要重写 Activity 的 getResources() 方法
     */
    override fun getResources(): Resources {
        AutoSizeCompat.autoConvertDensityOfGlobal(super.getResources())
        return super.getResources()
    }

    /**
     * 设置全屏？
     */
    protected open fun isBaseFullScreen(): Boolean {
        return false
    }

    /**
     * 状态栏图标颜色 默认黑色
     *
     * @return
     */
    protected open fun isStatuBarLightMode(): Boolean? {
        return true
    }

    /**
     * 状态栏是否需要间距
     *
     * @return
     */
    protected open fun isStatusBarNoPadding(): Boolean {
        return false
    }

    protected open fun setDefaultBarColor(): Int {
        return Color.WHITE
    }

    private fun fullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }


    /**
     * 设置状态栏透明
     */
    protected open fun setStatuBarTransparency() {
        StatusBarUtil.transparentStatusBar(this)
        val barLightMode = isStatuBarLightMode()
        if (barLightMode != false) {
            StatusBarUtil.setLightMode(this)
        } else {

        }
    }

    /**
     * 根据状态栏高度填充或设置传入的颜色
     *
     * @param color
     */
    open fun addStatusViewWithColor(color: Int) {
        //设置 paddingTop
        var mStatusBarView: View? = null
        val rootView =
            this.window.decorView.findViewById<ViewGroup>(R.id.content)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            rootView.setPadding(0, BarUtils.getStatusBarHeight(), 0, 0)
            val decorView = this.window.decorView as ViewGroup
            mStatusBarView = View(this)
            val lp = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                BarUtils.getStatusBarHeight()
            )
            mStatusBarView?.setBackgroundColor(color)
            decorView.addView(mStatusBarView, lp)
        }
    }


}