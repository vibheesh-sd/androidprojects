package com.example.recipeapp.entities.converter

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.recipeapp.entities.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import kotlin.reflect.typeOf

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(Category:List<Category>):String?{
        if (Category == null){
            return (null)
        }else{
            val gson = Gson()
            val  type = object : TypeToken<Category>(){

            }.type
            return gson.toJson(Category,type)
        }
    }

    @TypeConverter
    fun toCategoryList(CategoryString:String):List<Category>?{
        if (CategoryString == null){
            return (null)
        }else{
            val gson = Gson()
            val type = object : TypeToken<Category>(){

            }.type
            return gson.fromJson(CategoryString,type)
        }
    }

}