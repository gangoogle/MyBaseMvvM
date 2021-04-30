package com.example.mymvvmproject.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.mymvvmproject.R
import com.example.mymvvmproject.api.base.BaseFragment
import com.example.mymvvmproject.databinding.FragmentUserListBinding
import com.example.mymvvmproject.viewmodel.state.UserListViewModel

class UserListFragment : BaseFragment<UserListViewModel, FragmentUserListBinding>() {

    override fun layoutId(): Int {
        return R.layout.fragment_user_list
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.vm = mViewModel
    }


}