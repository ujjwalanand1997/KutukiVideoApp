package paging.android.example.com.pagingsample.ui.activities

import android.os.Bundle
import android.widget.MediaController
import androidx.activity.viewModels
import paging.android.example.com.pagingsample.BR
import paging.android.example.com.pagingsample.R
import paging.android.example.com.pagingsample.base.BaseActivity
import paging.android.example.com.pagingsample.databinding.ActivityVideoBinding
import paging.android.example.com.pagingsample.utilities.VIDEO_URL
import paging.android.example.com.pagingsample.viewmodel.VideoViewModel
import paging.android.example.com.pagingsample.viewmodel.VideoViewModelFactory

class VideoActivity : BaseActivity<ActivityVideoBinding, VideoViewModel>() {

    override fun getLayoutId() = R.layout.activity_video

    override fun getBindingVariable() = BR.video

    override fun initializeViews(bundle: Bundle?) {

        val url = intent.getStringExtra(VIDEO_URL)

        val videoView = getViewDataBinding()?.viewVideo
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        mediaController.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))

        videoView?.setVideoPath(url)

        videoView?.setMediaController(mediaController)
        videoView?.start()

        getViewDataBinding()?.btnClose?.setOnClickListener {
            finish()
        }
    }

    override fun getViewModel(): VideoViewModel {
        val viewModel by viewModels<VideoViewModel> { VideoViewModelFactory(application) }
        return viewModel
    }
}