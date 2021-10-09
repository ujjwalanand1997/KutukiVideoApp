package paging.android.example.com.pagingsample.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import paging.android.example.com.pagingsample.BR
import paging.android.example.com.pagingsample.R
import paging.android.example.com.pagingsample.adapter.VideoAdapter
import paging.android.example.com.pagingsample.base.BaseActivity
import paging.android.example.com.pagingsample.callbacks.ThumbnailCallback
import paging.android.example.com.pagingsample.data.VideoDescription
import paging.android.example.com.pagingsample.databinding.ActivityVideoListBinding
import paging.android.example.com.pagingsample.utilities.VIDEO_URL
import paging.android.example.com.pagingsample.viewmodel.VideoViewModel
import paging.android.example.com.pagingsample.viewmodel.VideoViewModelFactory

class VideoListActivity : BaseActivity<ActivityVideoListBinding, VideoViewModel>(), ThumbnailCallback {

    override fun getLayoutId() = R.layout.activity_video_list

    override fun getBindingVariable() = BR.videoData

    override fun initializeViews(bundle: Bundle?) {
        val adapter = VideoAdapter(this)
        getViewDataBinding()?.rvVideos?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        getViewDataBinding()?.rvVideos?.adapter = adapter

        getViewModel().getVideos()

        getViewModel().videoListLiveData.observe(this,{
            if (it.size>0){
                getViewModel().selectedVid.value = it[0]
                adapter.setData(it)
            }
        })

        getViewDataBinding()?.btnPlay?.setOnClickListener {
            if (getViewModel().selectedVid.value!=null) {
                val intent = Intent(this, VideoActivity::class.java)

                intent.putExtra(VIDEO_URL, getViewModel().selectedVid.value?.videoURL)

                startActivity(intent)
            }
        }

        getViewDataBinding()?.btnBack?.setOnClickListener {
            finish()
        }

    }

    override fun getViewModel(): VideoViewModel {
        val viewModel by viewModels<VideoViewModel> { VideoViewModelFactory(application) }
        return viewModel
    }

    override fun onVideoClick(item: VideoDescription) {
        getViewModel().selectedVid.value = item
    }

}