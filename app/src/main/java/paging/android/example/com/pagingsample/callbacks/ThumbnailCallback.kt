package paging.android.example.com.pagingsample.callbacks

import paging.android.example.com.pagingsample.data.VideoDescription

interface ThumbnailCallback {

    fun onVideoClick(item: VideoDescription)

}