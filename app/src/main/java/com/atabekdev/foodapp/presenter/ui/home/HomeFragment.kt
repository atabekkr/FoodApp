package com.atabekdev.foodapp.presenter.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.atabekdev.foodapp.R
import com.atabekdev.foodapp.databinding.FragmentHomeBinding
import com.atabekdev.foodapp.databinding.ItemFreshRecipeBinding
import com.atabekdev.foodapp.presenter.ui.adapter.FreshRecipeAdapter
import com.atabekdev.foodapp.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModels<MainViewModel>()

    private val adapter = FreshRecipeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupData()
        loadData()
        setupObservers()

    }

    private fun setupData() {
        binding.recyclerView.adapter = adapter
    }

    private fun loadData() {

        viewModel.getFreshRecipes()
    }

    private fun setupObservers() {
        viewModel.mealsResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                adapter.submitList(it)
            }
            result.onFailure {
                Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

}