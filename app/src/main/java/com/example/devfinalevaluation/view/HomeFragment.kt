package com.example.devfinalevaluation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devfinalevaluation.R
import com.example.devfinalevaluation.adapter.PhotosAdapter
import com.example.devfinalevaluation.databinding.FragmentHomeBinding
import com.example.devfinalevaluation.model.Photos
import com.example.devfinalevaluation.repository.HomeActivityRepository
import com.example.devfinalevaluation.room.PhotoDatabase
import com.example.devfinalevaluation.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var photosAdapter: PhotosAdapter
    private val photoList = ArrayList<Photos>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater)

        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getServicesAPICall()



        viewModel.setHomeRepository(
            HomeActivityRepository(
                PhotoDatabase.getDataBase(
                    activity?.applicationContext!!
                ), requireActivity().applicationContext
            )
        )
        viewModel.getServicesAPICall()?.observe(viewLifecycleOwner, Observer { pList ->
            photoList.addAll(pList)
            photosAdapter.setPhotoList(photoList)

            Toast.makeText(requireContext(), "size:${photoList.size}", Toast.LENGTH_LONG).show()

        })


        return binding.root
    }

    private fun prepareRecyclerView() {
        photosAdapter = PhotosAdapter { position ->
            onListItemClick(position)
        }
        binding.rvPhotos.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = photosAdapter

        }
    }


    private fun onListItemClick(position: Int) {

        val title = photoList[position].title
        val id = photoList[position].id

        val bundle = bundleOf("title" to title, "id" to id)


        view?.findNavController()?.navigate(R.id.detailedFragment, bundle)
    }


}