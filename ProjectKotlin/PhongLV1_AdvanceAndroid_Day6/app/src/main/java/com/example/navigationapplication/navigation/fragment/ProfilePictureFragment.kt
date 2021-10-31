package com.example.navigationapplication.navigation.fragment

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.navigationapplication.R
import com.example.navigationapplication.databinding.FragmentProfilePictureBinding
import java.util.jar.Manifest

class ProfilePictureFragment : Fragment() {
    private val REQUEST_CODE_CAMERA = 2
    private val REQUEST_CODE = 1
    private lateinit var binding: FragmentProfilePictureBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfilePictureBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        binding.tvUpload.setOnClickListener {
            openPhoto()
        }
        binding.tvTakePhoto.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireContext(),android.Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED){
                openCamera()
            }else{
                ActivityCompat.requestPermissions(requireActivity(),
                    arrayOf(android.Manifest.permission.CAMERA), 1)
            }
        }
        binding.btnSkip.setOnClickListener {
            ProfilePictureFragmentDirections.actionProfilePictureFragmentToHomeActivity().apply {
                findNavController().navigate(this)
            }
        }
        binding.btnFinish.setOnClickListener {
            ProfilePictureFragmentDirections.actionProfilePictureFragmentToHomeActivity().apply {
                findNavController().navigate(this)
            }
        }
        return binding.root
    }


    fun openPhoto() = Intent(Intent.ACTION_PICK).apply {
            type = "image/*"
            startActivityForResult(this,REQUEST_CODE)
        }
    fun openCamera() = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
        startActivityForResult(this,REQUEST_CODE_CAMERA)
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1){
            openCamera()
        }else{
            Toast.makeText(context,"No Permission Camera", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            binding.imgAvatar.setImageURI(data?.data)
        }
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_CAMERA){
            binding.imgAvatar.setImageBitmap(data?.extras?.get("data") as Bitmap)
        }
    }
}