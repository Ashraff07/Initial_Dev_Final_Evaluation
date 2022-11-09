package com.example.devfinalevaluation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.devfinalevaluation.R
import com.example.devfinalevaluation.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)

        binding.login.setOnClickListener{

            RegistrationUtil.validate("fweifhiud","fdsfdsfa")

            view?.findNavController()?.navigate(R.id.homeFragment)
        }


        return binding.root

    }


}
