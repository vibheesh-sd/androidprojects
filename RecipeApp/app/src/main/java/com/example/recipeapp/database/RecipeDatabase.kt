package com.example.recipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipeapp.dao.RecipeDao
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.CategoryItems
import com.example.recipeapp.entities.Recipies
import com.example.recipeapp.entities.converter.CategoryListConverter
import java.security.AccessControlContext

@Database(entities = [Recipies::class,CategoryItems::class,Category::class,CategoryListConverter::class],version = 1,exportSchema = false)
abstract class RecipeDatabase:RoomDatabase() {

    companion object{

        var recipeDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if(recipeDatabase!= null){
                recipeDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipie.db"
                ).build()
            }
            return recipeDatabase!!
        }
    }


    abstract fun recipieDao():RecipeDao
}