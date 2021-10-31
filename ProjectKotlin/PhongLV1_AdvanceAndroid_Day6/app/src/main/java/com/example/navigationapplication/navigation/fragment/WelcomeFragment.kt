package com.example.navigationapplication.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationapplication.R
import com.example.navigationapplication.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        binding.btnSignUp.setOnClickListener {
           WelcomeFragmentDirections.actionWelcomeFragmentToSignUpFragment2().apply {
               findNavController().navigate(this)
           }
        }
        binding.btnLogin.setOnClickListener {
            WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment().apply {
                findNavController().navigate(this)
            }
        }
        return binding.root
    }

}