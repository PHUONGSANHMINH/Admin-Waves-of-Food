package com.example.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.admin.adapter.DeliveryAdapter
import com.example.admin.databinding.ActivityOutForDeliveryBinding

class OutForDeliveryActivity : AppCompatActivity() {

    private val binding: ActivityOutForDeliveryBinding by lazy {
        ActivityOutForDeliveryBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customerName = arrayListOf(
            "John Doe",
            "Jane Smith",
            "Mike Johnson",
        )

        val moneyStatus = arrayListOf(
            "received",
            "notReceived",
            "Pending",
        )

        val adapter = DeliveryAdapter(customerName, moneyStatus)
        binding.deliveryRecyclerView.adapter = adapter
        binding.deliveryRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}