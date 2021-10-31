package com.example.navigationapplication.navigation.fragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.navigationapplication.R
import com.example.navigationapplication.databinding.FragmentProfileBinding
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        binding.edtBirthday.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                binding.edtBirthday.setText("$dayOfMonth/$monthOfYear/$year")
            }, year, month, day)
            dpd.show()
        }
        binding.btnContinue.setOnClickListener {
            if (checkValid()){
                ProfileFragmentDirections.actionProfileFragmentToProfilePictureFragment().apply {
                    findNavController().navigate(this)
                }
            }else {
                Toast.makeText(context,"Invalid", Toast.LENGTH_SHORT).show()
            }

        }
        return binding.root
    }
    fun checkValid(): Boolean{
        val firstName = binding.edtFirstName.text.toString()
        val lastName = binding.edtLastName.text.toString()
        val email = binding.edtEmail.text.toString()
        val dateOfBirth = binding.edtBirthday.text.toString()
        if(firstName.isBlank() || lastName.isBlank() || email.isBlank() || dateOfBirth.isBlank())
            return false
        return true
    }
}