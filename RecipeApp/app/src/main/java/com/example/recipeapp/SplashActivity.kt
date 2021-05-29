package com.example.recipeapp

import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.recipeapp.RetrofitClientInstance.RetrofitClientInstance
import com.example.recipeapp.entities.Category
import com.example.recipeapp.interfaces.GetDataService
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Response
import java.security.Provider
import java.util.*
import javax.security.auth.callback.Callback

class SplashActivity : BaseActivity(),EasyPermissions.RationalCallbacks, EasyPermission.PermissionCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        btnGetStarted.setOnClickListener{
            var intent = Intent(this@SplashActivity,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getCategories(){
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getCatogryList()
       call.enqueue(object : Callback<Category>(), retrofit2.Callback<Category> {
           override fun onFailure(call: Call<Category>, t: Throwable) {

               loader.visibility = View.INVISIBLE
               Toast.makeText(this@SplashActivity,"Something went wrong",Toast.LENGTH_SHORT).show()
           }
           override fun onResponse(
               call: Call<Category>,
               response: Response<Category>) {

           }

           ){
               //insertDataIntoRoomDb(response.body)
           }



       })

    }

    fun insertDataIntoRoomDb(category: List<Category>?){

    }
}