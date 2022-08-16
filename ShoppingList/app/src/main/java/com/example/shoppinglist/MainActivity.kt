package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter: listAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listAdapter = listAdapter(mutableListOf())

        rvShoppingItems.adapter = listAdapter
        rvShoppingItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val itemTitle = etShoppingList.text.toString()
            if(itemTitle.isNotEmpty()) {
                val item = list(itemTitle)
                listAdapter.addItem(list)
                etShoppingList.text.clear()
            }
        }
        btnDelItem.setOnClickListener {
            listAdapterAdapter.deleteDoneTodos()
        }
    }
}