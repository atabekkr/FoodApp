package com.atabekdev.foodapp.presenter.ui.overview

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.atabekdev.foodapp.R
import com.atabekdev.foodapp.databinding.FragmentOverviewBinding
import com.atabekdev.foodapp.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OverviewFragment : Fragment(R.layout.fragment_overview) {

    private val binding by viewBinding(FragmentOverviewBinding::bind)
    private val navArgs by navArgs<OverviewFragmentArgs>()
    private val viewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        setupListeners()
        setupObservers()

    }

    private fun loadData() {
        viewModel.getMealById(navArgs.mealId.toInt())
    }

    private fun setupListeners() {
        binding.ivBack.setOnClickListener { findNavController().popBackStack() }
    }

    private fun setupObservers() {
        viewModel.getMealResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                binding.tvDescription.text = it.instruction
                binding.tvCookToday.text = it.nameOfMeal
                binding.tvMode.text = it.strCategory
            }
            result.onFailure {
                Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}