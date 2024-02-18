package com.example.newvesionplas.ui.parent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.newvesionplas.databinding.ActivityParentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityParentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.GONE
        binding= ActivityParentBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}