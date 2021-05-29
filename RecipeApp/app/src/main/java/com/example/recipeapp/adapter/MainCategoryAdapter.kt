package com.example.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.entities.Recipies
import kotlinx.android.synthetic.main.item_rv_sub_category.view.*

class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var arrMainCategory = ArrayList<Recipies>()
    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){

    }
     fun setData(arrData : List<Recipies>) {
         arrMainCategory = arrData as ArrayList<Recipies>
     }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
       return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.tv_dish_name.text = arrMainCategory[position].dishName
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }
}