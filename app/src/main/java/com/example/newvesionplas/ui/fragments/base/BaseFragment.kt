package com.example.newvesionplas.ui.fragments.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newvesionplas.R
import com.example.newvesionplas.databinding.FragmentBaseBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class BaseFragment : Fragment() {
    private var _binding: FragmentBaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBaseBinding.bind(view)

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.home_nav) as NavHostFragment
        val navController = navHostFragment.navController
        binding.homeBtnNav.setupWithNavController(navController)



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}