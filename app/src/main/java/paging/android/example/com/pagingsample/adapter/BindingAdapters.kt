package paging.android.example.com.pagingsample.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromPath")
fun bindImageFromPath(view: ImageView, imagePath: String?) {
    if (!imagePath.isNullOrEmpty()) {

        Glide.with(view.context)
            .load(imagePath)
            .into(view)

    }
}