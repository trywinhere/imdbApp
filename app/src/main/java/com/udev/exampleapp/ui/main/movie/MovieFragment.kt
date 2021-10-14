package com.udev.exampleapp.ui.main.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udev.exampleapp.R
import com.udev.exampleapp.databinding.FragmentMovieBinding
import com.udev.exampleapp.injection.scopes.FragmentScoped
import com.udev.exampleapp.ui.main.BaseMainFragment
import com.udev.exampleapp.ui.main.movielist.adapter.ImagesListAdapter
import com.udev.exampleapp.utils.Resource

@FragmentScoped
class MovieFragment :
    BaseMainFragment<MovieViewModel, FragmentMovieBinding>(R.layout.fragment_movie){

    val imageListAdapter: ImagesListAdapter = ImagesListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val movieId = arguments?.getString("MOVIE_ID")
        movieId?.let { viewModel.getMovieImages(movieId) }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initiateViewModels()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun initViews() {
        binding.apply {
            rvMovieImages.adapter = imageListAdapter
        }
    }

    private fun initiateViewModels() {
        viewModel.movieResult.observe(viewLifecycleOwner) {
            when(it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { data -> imageListAdapter.setData(data.images) }
                }
                Resource.Status.LOADING -> {

                }
                Resource.Status.ERROR -> {
                    onError(it.message)
                }
            }
        }
    }

}