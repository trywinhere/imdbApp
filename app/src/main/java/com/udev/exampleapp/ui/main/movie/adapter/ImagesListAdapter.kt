package com.udev.exampleapp.ui.main.movielist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.udev.exampleapp.R
import com.udev.exampleapp.injection.data.model.Movie
import com.bumptech.glide.Glide
import com.udev.exampleapp.injection.data.source.remote.model.FilmImages
import com.udev.exampleapp.injection.data.source.remote.model.FilmImagesData
import com.udev.exampleapp.utils.SingleLiveEvent

class ImagesListAdapter() :
    RecyclerView.Adapter<ImagesListAdapter.MyViewHolder>() {

    private var mMovieList = listOf<FilmImages>()

    fun setData(data: List<FilmImages>) {
        mMovieList = data
        notifyDataSetChanged()
    }


//    val onEditorAction = SingleLiveEvent<EditorAction>()

    class MyViewHolder(
        itemView: View,
//        val onEditorAction: SingleLiveEvent<EditorAction>,
//        val activeLayerData: LiveData<Layer?>
    ) :
        RecyclerView.ViewHolder(itemView) {

        @SuppressLint("DefaultLocale", "UseCompatLoadingForDrawables")
        fun bind(
            item: FilmImages,
            position: Int
        ) {
            val poster = itemView.findViewById<ImageView>(R.id.poster)



            Glide.with(itemView.context).load(item.image)
                .into(poster)

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_images, parent, false)
        return MyViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int {
        return mMovieList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(
            mMovieList[position],
            position
        )
    }


}