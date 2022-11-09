package com.example.devfinalevaluation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.devfinalevaluation.R
import com.example.devfinalevaluation.databinding.ItemPhotosBinding
import com.example.devfinalevaluation.diffutil.MyDiffUtil
import com.example.devfinalevaluation.model.Photos

import com.example.devfinalevaluation.view.HomeFragment

class PhotosAdapter(private val onItemClicked: (position: Int) -> Unit) :
    RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {
    private var oldItemList = emptyList<Photos>()
    private var photoList = ArrayList<Photos>()
    fun setPhotoList(photoList: List<Photos>) {
        this.photoList = photoList as ArrayList<Photos>

        val diffUtil = MyDiffUtil(oldItemList, photoList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldItemList = photoList
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(val binding:ItemPhotosBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPhotosBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.title.text = photoList[position].title

        holder.itemView.setOnClickListener {
            onItemClicked(position)
        }



    }

    override fun getItemCount(): Int {
        return photoList.size
    }


}