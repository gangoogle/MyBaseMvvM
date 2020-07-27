package com.example.mymvvmproject.api.base

import android.view.View
import me.hgj.jetpackmvvm.ext.nav

/**
 *  @author zgyi
 *  @date 2020/7/27
 *  @Description:
 */

open class BaseProxyClick {

    open fun getView(): View? {
        return null
    }

    open fun onNavTitleLeftClick() {
        getView()?.let {
            nav(it).popBackStack()
        }
    }

}