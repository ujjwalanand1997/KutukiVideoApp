package paging.android.example.com.pagingsample.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import paging.android.example.com.pagingsample.callbacks.ThumbnailCallback
import paging.android.example.com.pagingsample.data.VideoDescription
import paging.android.example.com.pagingsample.databinding.ListVideosBinding
import paging.android.example.com.pagingsample.ui.activities.VideoActivity

class VideoAdapter(var callback: ThumbnailCallback) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    val list = arrayListOf<VideoDescription>()

    class VideoViewHolder(
        private val binding: ListVideosBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: VideoDescription?) {
            binding.apply {
                videoData = item
                executePendingBindings()
            }
        }
    }


    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

        holder.bind(list[position])

        holder.itemView.setOnClickListener {

            callback.onVideoClick(list[position])

        }
    }

    fun setData(arr: ArrayList<VideoDescription>) {
        list.clear()
        list.addAll(arr)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ListVideosBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun getItemCount() = list.size
}

