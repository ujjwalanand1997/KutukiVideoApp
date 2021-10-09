package paging.android.example.com.pagingsample.viewmodel

import androidx.lifecycle.MutableLiveData
import paging.android.example.com.pagingsample.base.BaseViewModel
import paging.android.example.com.pagingsample.data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideoViewModel : BaseViewModel() {


    val selectedVid = MutableLiveData<VideoDescription>()

    val api = VideoService.create()

    val categoryService = api.getCategories()

    val videoService = api.getVideos()

    val listLiveData = MutableLiveData<ArrayList<Description>>(arrayListOf())

    val videoListLiveData = MutableLiveData<ArrayList<VideoDescription>>(arrayListOf())

    fun getCategories() {
        categoryService.enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                if (response.body()?.code == 200) {

                    val arr = arrayListOf<Description>()

                    response.body()?.response?.videoCategories?.values?.forEach {
                        arr.add(it)
                    }

                    listLiveData.value = arr

                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {

            }

        })


    }

    fun getVideos() {
        videoService.enqueue(object : Callback<VideosResponse> {

            override fun onResponse(
                call: Call<VideosResponse>,
                response: Response<VideosResponse>
            ) {
                val arr = arrayListOf<VideoDescription>()

                response.body()?.response?.videos?.values?.forEach {
                    arr.add(it)
                }

                videoListLiveData.value = arr
            }

            override fun onFailure(call: Call<VideosResponse>, t: Throwable) {

            }

        })


    }

}
