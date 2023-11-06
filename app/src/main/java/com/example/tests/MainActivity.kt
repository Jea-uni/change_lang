package com.example.tests

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataLang : ArrayList<DataClass>
    private lateinit var text : TextView
    lateinit var lang_list :Array<String>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lang_list = arrayOf(
            "Italiano",
            "Inglese",
            "Tedesco",
            "Francese"
        )

        recyclerView = findViewById(R.id.avail_lang)
        recyclerView.layoutManager =LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


        dataLang = arrayListOf<DataClass>()

        getData()


    }

    private fun getData(){
        for(i in lang_list.indices){
            val dataClassLang =DataClass(lang_list[i])
            dataLang.add(dataClassLang)
        }
        recyclerView.adapter = AdapterClass(dataLang)
    }


}