package paging.android.example.com.pagingsample.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import paging.android.example.com.pagingsample.BR
import paging.android.example.com.pagingsample.R
import paging.android.example.com.pagingsample.adapter.CategoryAdapter
import paging.android.example.com.pagingsample.base.BaseActivity
import paging.android.example.com.pagingsample.databinding.ActivityHomeBinding
import paging.android.example.com.pagingsample.viewmodel.VideoViewModel
import paging.android.example.com.pagingsample.viewmodel.VideoViewModelFactory

class HomeActivity : BaseActivity<ActivityHomeBinding, VideoViewModel>() {

    override fun getLayoutId() = R.layout.activity_home

    override fun getBindingVariable() = BR.homeViewModel

    override fun initializeViews(bundle: Bundle?) {
        val adapter = CategoryAdapter()
        getViewDataBinding()?.noteList?.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        getViewDataBinding()?.noteList?.adapter = adapter

        getViewModel().getCategories()

        getViewModel().listLiveData.observe(this, {
            adapter.setData(it)
        })

    }

    override fun getViewModel(): VideoViewModel {
        val viewModel by viewModels<VideoViewModel> { VideoViewModelFactory(application) }
        return viewModel
    }
}
