package com.example.navigationapplication.navigation.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.navigationapplication.R
import com.example.navigationapplication.data.AccountModel
import com.example.navigationapplication.data.AccountViewModel
import com.example.navigationapplication.data.AccountViewModelFactory
import com.example.navigationapplication.databinding.FragmentSignUpBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding

    private val viewModel: AccountViewModel by viewModels(){
        AccountViewModelFactory(requireActivity().application)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        binding.btnSignUp.setOnClickListener {
            val phone = binding.edtPhoneNumber.text.toString()
            val password =  binding.edtPassword.text.toString()
            val repassword = binding.edtConfirmPass.text.toString()
            val checkBox = binding.ckbAgree
            if (checkValid(phone,password,repassword,checkBox)){
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.addAccount(AccountModel(phone = phone,password = password))
                }
                SignUpFragmentDirections.actionSignUpFragmentToProfileFragment().apply {
                    findNavController().navigate(this)
                }
            }else{
                Toast.makeText(context,"Invalid",Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    fun checkValid(phone: String, password: String, repassword: String, check: CheckBox): Boolean{
        if (phone.length != 10) return false
        if(phone.isNullOrBlank() || password.isNullOrBlank() || repassword.isNullOrBlank())
            return false
        if (password.length < 6)
            return false
        if (repassword != password)
            return false
        if(!check.isChecked)
            return false
        return true
    }

}