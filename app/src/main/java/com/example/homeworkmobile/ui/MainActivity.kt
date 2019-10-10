package com.example.homeworkmobile.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworkmobile.Adapter.PhonesAdapter
import com.example.homeworkmobile.R
import com.example.homeworkmobile.api.PhoneApi
import com.example.homeworkmobile.model.Phone
import kotlinx.android.synthetic.main.activity_brand.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import retrofit2.Callback
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(Color.WHITE)
        supportActionBar?.title = "Phones"
        fetchPhone()

        txtAll.setOnClickListener {
            val intent = Intent(this, BrandActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchPhone() {
        PhoneApi.invoke().getPhones().enqueue(object : Callback<List<Phone>> {
            override fun onFailure(call: Call<List<Phone>>, t: Throwable) {
                Toast.makeText(applicationContext, "Fetch phone error", Toast.LENGTH_LONG).show()
                Log.d("api", "error: $t")
            }

            override fun onResponse(call: Call<List<Phone>>, response: Response<List<Phone>>) {
                val phones = response.body()

                phones?.let {
                    showPhones(it)
                }
            }

        })
    }

    private fun showPhones(phones: List<Phone>) {
        recyclerViewPhone.layoutManager = LinearLayoutManager(this)
        recyclerViewPhone.adapter = PhonesAdapter(phones)
    }
}
