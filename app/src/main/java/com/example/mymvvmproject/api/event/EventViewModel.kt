package com.example.mymvvmproject.api.event

import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.callback.livedata.event.EventLiveData

/**
 * @author zgyi
 * @date 2020/7/23
 * @Description:全局event事件，替代eventBus
 */
class EventViewModel : BaseViewModel() {

    //全局 event测试事件
    val onSendTextTestEvent = EventLiveData<Boolean>()


}