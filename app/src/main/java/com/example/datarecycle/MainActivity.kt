package com.example.datarecycle;

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datarecycle.Item
import com.example.datarecycle.ItemAdapter
import com.example.datarecycle.R


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private val itemList = mutableListOf<Item>()
    private var itemCount = 4 // Counter for item names

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Tambahkan data statis awal
        itemList.add(Item("Item 1"))
        itemList.add(Item("Item 2"))
        itemList.add(Item("Item 3"))

        itemAdapter = ItemAdapter(itemList)
        recyclerView.adapter = itemAdapter

        // Tombol untuk menambah item
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        buttonAdd.setOnClickListener {
            itemList.add(Item("Item $itemCount"))
            itemCount++
            itemAdapter.notifyDataSetChanged() // Update RecyclerView
        }
    }
}
