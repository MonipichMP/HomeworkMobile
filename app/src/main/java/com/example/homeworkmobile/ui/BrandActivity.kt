package com.example.homeworkmobile.ui

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworkmobile.Adapter.BrandsAdapter
import com.example.homeworkmobile.R
import com.example.homeworkmobile.api.BrandApi
import com.example.homeworkmobile.model.Brand
import kotlinx.android.synthetic.main.activity_brand.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrandActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brand)

        setSupportActionBar(toolbarBrand)
        toolbarBrand.setTitleTextColor(Color.WHITE)
        supportActionBar?.title = "Brands"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        fetchBrand()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun fetchBrand() {
        BrandApi.invoke().getBrands().enqueue(object : Callback<List<Brand>> {
            override fun onFailure(call: Call<List<Brand>>, t: Throwable) {
                Toast.makeText(applicationContext, "Fetch brand error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Brand>>, response: Response<List<Brand>>) {
                val brands = response.body()

                brands?.let {
                    showBrands(it)
                }
            }

        })
    }

    private fun showBrands(brands: List<Brand>) {
        recyclerViewBrand.layoutManager = LinearLayoutManager(this)
        recyclerViewBrand.adapter = BrandsAdapter(brands)
    }
}