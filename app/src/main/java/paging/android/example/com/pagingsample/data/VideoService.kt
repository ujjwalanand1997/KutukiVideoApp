package paging.android.example.com.pagingsample.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface VideoService {

    @GET("5e2bebd23100007a00267e51")
    fun getCategories() : Call<CategoryResponse>

    @GET("5e2beb5a3100006600267e4e")
    fun getVideos() : Call<VideosResponse>

    companion object {

        var BASE_URL = "https://www.mocky.io/v2/"

        fun create() : VideoService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(VideoService::class.java)

        }
    }
}