package com.atabekdev.foodapp.presenter.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.atabekdev.foodapp.databinding.ItemFreshRecipeBinding
import com.atabekdev.foodapp.presenter.models.MealUI

class FreshRecipeAdapter : ListAdapter<MealUI, FreshRecipeAdapter.OfferViewHolder>(MyDiffUtil()) {

    inner class OfferViewHolder(private val binding: ItemFreshRecipeBinding) :
        ViewHolder(binding.root) {
        fun bind() {
            val item = getItem(adapterPosition)

            binding.tvModeOfMeal.text = item.strCategory
            binding.tvNameOfMeal.text = item.nameOfMeal

            binding.root.setOnClickListener {
                onClick.invoke(item.idMeal ?: "52777")
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        return OfferViewHolder(
            ItemFreshRecipeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind()
    }

    private var onClick: (content: String) -> Unit = {}
    fun setOnItemClickListener(onClick: (content: String) -> Unit) {
        this.onClick = onClick
    }


    private class MyDiffUtil : DiffUtil.ItemCallback<MealUI>() {
        override fun areItemsTheSame(oldItem: MealUI, newItem: MealUI): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: MealUI, newItem: MealUI): Boolean {
            return oldItem == newItem
        }

    }
}