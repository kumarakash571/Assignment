package com.akash.assignment

import android.nfc.tech.MifareUltralight
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.akash.assignment.adapters.AuthorsAdapter
import com.akash.assignment.databinding.ActivityMainBinding
import com.akash.assignment.m.StoriesModel
import com.akash.assignment.utilities.ApiInterface
import com.akash.assignment.utilities.Client
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import android.nfc.tech.MifareUltralight.PAGE_SIZE

import androidx.recyclerview.widget.RecyclerView




class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: AuthorsAdapter
    var isLoading = true
    var isLastPage = true

     var layoutManager: LinearLayoutManager= LinearLayoutManager(this)
    var page  = 1;
     var mlist:List<StoriesModel.Hit> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        getDataFromAPI(page)
    }

    private fun getDataFromAPI(page: Int) {
        val api = Client.getInstance().create(ApiInterface::class.java)
        api.getTopics(page).enqueue(object : retrofit2.Callback<StoriesModel>{
            override fun onResponse(call: Call<StoriesModel>, response: Response<StoriesModel>) {
                mlist = response.body()?.hits as List<StoriesModel.Hit>
                Log.d("tag",mlist.toString())
                adapter = AuthorsAdapter(this@MainActivity,mlist)
                adapter.setData(mlist)
                binding.recyclerView.layoutManager = layoutManager
                binding.recyclerView.adapter = adapter


            }

            override fun onFailure(call: Call<StoriesModel>, t: Throwable) {
                Log.d("tag",t.message.toString())
            }

        })
    }

}