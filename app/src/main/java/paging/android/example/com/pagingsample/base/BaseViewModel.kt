package paging.android.example.com.pagingsample.base

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import paging.android.example.com.pagingsample.utilities.HandleOnceLiveEvent


abstract class BaseViewModel : ViewModel() {
    private val appCommonAlertObservable = MutableLiveData<HandleOnceLiveEvent<String>>()
    private val mIsLoading: MutableLiveData<Boolean?> = MutableLiveData()

    @MainThread
    fun alertObservable(): MutableLiveData<HandleOnceLiveEvent<String>> {
        return appCommonAlertObservable
    }
    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.value = isLoading
    }

    fun getIsLoading(): MutableLiveData<Boolean?>? {
        return mIsLoading
    }
}