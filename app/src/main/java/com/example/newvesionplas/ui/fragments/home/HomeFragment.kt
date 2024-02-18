package com.example.newvesionplas.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newvesionplas.ui.fragments.home.adapter.NewFilmsAdapter
import com.example.newvesionplas.R
import com.example.newvesionplas.databinding.FragmentHomeBinding
import com.example.newvesionplas.ui.fragments.home.adapter.UpComingFilmsAdapter
import com.example.newvesionplas.ui.fragments.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var upComingAdapter: UpComingFilmsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        binding.progressNew.visibility = View.VISIBLE
        binding.progressUpComing.visibility = View.VISIBLE
        //new films
        val filmsAdapter = NewFilmsAdapter { filmId ->
            val action = HomeFragmentDirections.actionHomeFragment3ToDetalisFragment(filmId)
            findNavController().navigate(action)
        }
        binding.view1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        homeViewModel.newFilms()
        lifecycleScope.launch {
            homeViewModel.newFilmLiveData.observe(viewLifecycleOwner) {
                filmsAdapter.submitList(it?.data)
                binding.progressNew.visibility = View.GONE
                binding.view1.adapter = filmsAdapter
            }
        }

        //upComing
        upComingAdapter = UpComingFilmsAdapter { filmId ->
            val action = HomeFragmentDirections.actionHomeFragment3ToDetalisFragment(filmId)
            findNavController().navigate(action)
        }
        binding.view2.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        homeViewModel.upComingFilms()
        lifecycleScope.launch {
            homeViewModel.upComingLiveData.observe(viewLifecycleOwner) {
                upComingAdapter.submitList(it.data)

                binding.progressUpComing.visibility = View.GONE
                binding.view2.adapter = upComingAdapter
            }
        }
        binding.searchEditText.setOnClickListener {
            val action =HomeFragmentDirections.actionHomeFragmentToSearchFragment()
            findNavController().navigate(action)
        }


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}