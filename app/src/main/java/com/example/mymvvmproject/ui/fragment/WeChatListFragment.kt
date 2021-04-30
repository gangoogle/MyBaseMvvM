package com.example.mymvvmproject.ui.fragment

import android.os.Bundle
import com.example.mymvvmproject.R
import com.example.mymvvmproject.api.base.BaseFragment
import com.example.mymvvmproject.databinding.FragmentWechatListBinding
import com.example.mymvvmproject.viewmodel.state.MainHomeViewModel

/**
 * 微信公众号列表
 */
class WeChatListFragment : BaseFragment<MainHomeViewModel, FragmentWechatListBinding>() {

    override fun layoutId(): Int {
        return R.layout.fragment_wechat_list
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
        super.createObserver()
    }


}