package paging.android.example.com.pagingsample.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import paging.android.example.com.pagingsample.data.Description
import paging.android.example.com.pagingsample.databinding.ListCategoryBinding
import paging.android.example.com.pagingsample.ui.activities.VideoActivity
import paging.android.example.com.pagingsample.ui.activities.VideoListActivity

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    val list = arrayListOf<Description>()

    class CategoryViewHolder(
        private val binding: ListCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Description?) {
            binding.apply {
                categoryData = item
                executePendingBindings()
            }
        }

    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, VideoListActivity::class.java)

            holder.itemView.context.startActivity(intent)

        }
    }

    fun setData(arr: ArrayList<Description>) {
        list.clear()
        list.addAll(arr)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ListCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun getItemCount() = list.size
}

