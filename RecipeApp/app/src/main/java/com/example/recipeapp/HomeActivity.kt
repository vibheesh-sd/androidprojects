package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapp.adapter.MainCategoryAdapter
import com.example.recipeapp.adapter.SubCategoryAdapter
import com.example.recipeapp.entities.Recipies
import kotlinx.android.synthetic.main.activity_home.*
import javax.security.auth.Subject

class HomeActivity : BaseActivity() {
    var arrMainCategory = ArrayList<Recipies>()
    var  arrSubCategory = ArrayList<Recipies>()

    var  mainCategoryAdapter = MainCategoryAdapter()
    var  subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Temporary Data
        arrMainCategory.add(Recipies(1, "Beef"))
        arrMainCategory.add(Recipies(2, "Chicken"))
        arrMainCategory.add(Recipies(3, "Dessert"))
        arrMainCategory.add(Recipies(4, "Lamb"))

         mainCategoryAdapter.setData(arrMainCategory)

        arrSubCategory.add(Recipies(1, "Beef and mustard pie"))
        arrSubCategory.add(Recipies(2, "Chicken and mushroom hotpot"))
        arrSubCategory.add(Recipies(3, "Banana pancakes"))
        arrSubCategory.add(Recipies(4, "kapsalon"))

        subCategoryAdapter.setData(arrSubCategory)


        rv_main_category.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_main_category.adapter = mainCategoryAdapter

        rv_sub_category.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_sub_category.adapter = subCategoryAdapter

    }
}