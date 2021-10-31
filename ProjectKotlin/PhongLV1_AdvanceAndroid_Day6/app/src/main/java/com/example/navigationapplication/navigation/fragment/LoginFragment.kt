package com.example.navigationapplication.navigation.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.navigationapplication.R
import com.example.navigationapplication.data.AccountViewModel
import com.example.navigationapplication.data.AccountViewModelFactory
import com.example.navigationapplication.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: AccountViewModel by viewModels(){
        AccountViewModelFactory(requireActivity().application)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment

        binding.btnLogin.setOnClickListener {
            val phone = binding.edtPhoneNumber.text.toString()
            val password = binding.edtPassword.text.toString()

            viewModel.getAccount(phone,password).observe(requireActivity(), Observer {
                if (it==null){
                    Toast.makeText(context,"Invalid Account",Toast.LENGTH_SHORT).show()
                }else{
                    LoginFragmentDirections.actionLoginFragmentToHomeActivity().apply {
                        findNavController().navigate(this)
                    }
                }
            })
        }
        return binding.root
    }
}