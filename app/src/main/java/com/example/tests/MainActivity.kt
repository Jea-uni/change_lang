package com.example.tests

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList : ArrayList<DataClass>
    lateinit var lang_list :Array<String>
    lateinit var lang_list_abr:Array<String>
    lateinit var icon_list :Array<Int>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lang_list_abr = arrayOf(
            "it",
            "en"
        )

        lang_list = arrayOf(
            getString(R.string.it),
            getString(R.string.en)
        )

        icon_list = arrayOf(
            R.drawable.lang_it_inkseek,
            R.drawable.lang_eng_inkseek
        )


        recyclerView = findViewById(R.id.avail_lang)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


        dataList = arrayListOf<DataClass>()

        getData()

    }

    private fun getData(){
        for(i in lang_list.indices){
            val dataClass = DataClass(lang_list[i],icon_list[i],lang_list_abr[i])
            dataList.add(dataClass)
        }
        val itemAdapter = AdapterClass(dataList)
        recyclerView.adapter = itemAdapter

    }



}