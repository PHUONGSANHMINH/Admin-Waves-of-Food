package com.example.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.databinding.ActivityOrderDetailsBinding
import com.example.admin.model.OrderDetails

class OrderDetailsActivity : AppCompatActivity() {
    private val binding : ActivityOrderDetailsBinding by lazy {
        ActivityOrderDetailsBinding.inflate(layoutInflater)
    }

    private var userName: String ?= null
    private var address : String ?= null
    private var phoneNumber : String ?= null
    private var totalPrice : String ?= null
    private var foodNames : MutableList<String> = mutableListOf()
    private var foodImages : MutableList<String> = mutableListOf()
    private var foodQuantity: MutableList<Int> = mutableListOf()
    private var foodPrices : MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }
        getDataFromIntent()
    }

    private fun getDataFromIntent() {
        val receivedOrderDetails = intent.getParcelableExtra<OrderDetails>("UserOrderDetails")
        if (receivedOrderDetails != null){
            userName = receivedOrderDetails.userName
            foodNames = receivedOrderDetails.foodNames!!
            foodImages = receivedOrderDetails.foodImages!!
            foodQuantity = receivedOrderDetails.foodQuantities!!
            address = receivedOrderDetails.address
            phoneNumber = receivedOrderDetails.phoneNumber
            foodPrices = receivedOrderDetails.foodPrices!!
            totalPrice = receivedOrderDetails.totalPrice

            setUserDetail()

        }
    }

    private fun setUserDetail() {
        binding.name.text = userName
        binding.address.text = address
        binding.phone.text = phoneNumber
        binding.name.text = userName



    }
}