package com.example.devfinalevaluation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.devfinalevaluation.R
import com.example.devfinalevaluation.databinding.FragmentDetailedBinding
import com.example.devfinalevaluation.databinding.FragmentLoginBinding


class DetailedFragment : Fragment() {

    private lateinit var binding : FragmentDetailedBinding
    private  var title:Bundle?= null
    private var id:Bundle?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { bundle ->
            title = bundle.getBundle("title")
            id = bundle.getBundle("id")


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailedBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleDetailed.text = arguments?.getString("title")
        binding.idDetailed.text = arguments?.getString("id")
    }

}