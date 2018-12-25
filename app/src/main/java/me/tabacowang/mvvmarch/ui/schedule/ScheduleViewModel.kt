package me.tabacowang.mvvmarch.ui.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.tabacowang.mvvmarch.shared.result.Event
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(

) : ViewModel() {

    private val _navigateToScheduleDetail = MutableLiveData<Event<String>>()
    val navigateToScheduleDetail: LiveData<Event<String>>
        get() = _navigateToScheduleDetail

    fun openScheduleDetail(id: String) {
        _navigateToScheduleDetail.value = Event(id)
    }

}