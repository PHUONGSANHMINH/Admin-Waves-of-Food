package com.example.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.admin.adapter.DeliveryAdapter
import com.example.admin.adapter.PendingOrderAdapter
import com.example.admin.databinding.ActivityPendingOrderBinding
import com.example.admin.databinding.PendingOrdersItemBinding

class PendingOrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPendingOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPendingOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }

        val orderedCustomerName = arrayListOf(
            "John Doe",
            "Jane Smith",
            "Mike Johnson",
        )

        val orderedQuantity = arrayListOf(
            "8",
            "6",
            "5",
        )

        val orderedFoodImage = arrayListOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3)
        val adapter = PendingOrderAdapter(orderedCustomerName, orderedQuantity, orderedFoodImage, this)
        binding.pandingOrderRecyclerView.adapter = adapter
        binding.pandingOrderRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}