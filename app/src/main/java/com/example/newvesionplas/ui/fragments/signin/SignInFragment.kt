package com.example.newvesionplas.ui.fragments.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.newvesionplas.R
import com.example.newvesionplas.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
    private var _binding : FragmentSignInBinding? =null
    private val binding get() =_binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding=FragmentSignInBinding.bind(view)
        binding.signInBtn.setOnClickListener {
           view.findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToBaseFragment2())
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}