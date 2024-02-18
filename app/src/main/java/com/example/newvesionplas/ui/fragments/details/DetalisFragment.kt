package com.example.newvesionplas.ui.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnGenericMotionListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.newvesionplas.R
import com.example.newvesionplas.databinding.FragmentDetalisBinding
import com.example.newvesionplas.ui.fragments.details.viewmodel.DetalisViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class DetalisFragment : Fragment() {
    private var _binding: FragmentDetalisBinding? = null
    private val binding get() = _binding!!
    private val detalisViewModel : DetalisViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalis, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetalisBinding.bind(view)

        val filmId = arguments?.let {
            DetalisFragmentArgs.fromBundle(it).id
        } ?: ""
        if (filmId.isNotEmpty()) {
            detalisViewModel.getFilmDetails(filmId)
            detalisViewModel.getFilmDetails(filmId)
            detalisViewModel.filmDetails.observe(viewLifecycleOwner) { film ->
                // Use the film details
                if (film != null) {
                    val genres = film.genres.joinToString(", ")
                    Glide.with(requireContext()).load(film.images[0]).into(binding.posterBigImg)
                    Glide.with(requireContext()).load(film.poster).into(binding.posterNormalImg)
                    binding.movieSummaryInfo.text = film.genres.toString()
                    binding.movieRateTxt.text = film.imdb_rating
                    binding.movieNameTxt.text=film.title
                    binding.movieDateTxt.text=film.year
                    binding.movieSummaryInfo.text=genres
                    binding.movieCountryInfo.text=film.country

                } else {
                    Toast.makeText(requireContext(), "Film details not found", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else { Toast.makeText(requireContext(), "Invalid film ID", Toast.LENGTH_SHORT).show() }
        binding.backImg.setOnClickListener {
            findNavController().navigate(DetalisFragmentDirections.actionDetalisFragmentToHomeFragment())
        }




    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}