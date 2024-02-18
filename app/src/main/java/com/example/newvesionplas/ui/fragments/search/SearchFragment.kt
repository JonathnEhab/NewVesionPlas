package com.example.newvesionplas.ui.fragments.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newvesionplas.R
import com.example.newvesionplas.databinding.FragmentSearchBinding
import com.example.newvesionplas.ui.fragments.search.adapter.SearchAdapter
import com.example.newvesionplas.ui.fragments.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? =null
    private  val binding  get() = _binding!!
    private val searchViewModel :SearchViewModel by viewModels()
    private lateinit var searchAdapter : SearchAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding= FragmentSearchBinding.bind(view)
        binding.findFilmRecyclerView.layoutManager=
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.searchEditText.setOnClickListener {
            binding.searchEditText.isIconified=false
            binding.searchEditText.requestFocusFromTouch()
        }
        binding.searchEditText.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    searchViewModel.findFilm(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (!newText.isBlank()) {
                    searchViewModel.findFilm(newText)
                }

                return true
            }
        })
           searchAdapter = SearchAdapter { filmId ->
               val action = SearchFragmentDirections.actionSearchFragmentToDetalisFragment(id.toString())
               findNavController().navigate(action)

           }
        lifecycleScope.launch {
            searchViewModel.findFilm.observe(viewLifecycleOwner){
                searchAdapter.submitList(it)
                binding.findFilmRecyclerView.adapter=searchAdapter
                Log.d("TAGGOON", "onViewCreated: "+it.size)
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}