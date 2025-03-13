package com.anushka.viewmodeldemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityMainViewModel:ViewModel() {

    var total = MutableLiveData<Int>()
    val totalData : LiveData<Int>
        get() = total

    init {
        total.value = 5
    }

    fun setTotal(input:Int){
        total.value = total.value?.plus(input)
    }

}