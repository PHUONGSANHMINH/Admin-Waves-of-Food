package com.example.admin.model

import android.os.Parcel
import android.os.Parcelable

class OrderDetails() : Parcelable {
    var userUid : String ?= null
    var userName : String ?= null
    var foodNames : MutableList<String> ?= null
    var foodImages : MutableList<String> ?= null
    var foodPrices : MutableList<String> ?= null
    var foodQuantities: MutableList<Int> ?= null
    var address : String ?= null
    var totalPrice : String ?= null
    var phoneNumber : String ?= null
    var orderAccepted : Boolean ?= null
    var paymentReceived : Boolean ?= null
    var itemPushKey : String ?= null
    var currentTime : Long = 0

    constructor(parcel: Parcel) : this() {
        userUid = parcel.readString()
        userName = parcel.readString()
        address = parcel.readString()
        totalPrice = parcel.readString()
        phoneNumber = parcel.readString()
        orderAccepted = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        paymentReceived = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        itemPushKey = parcel.readString()
        currentTime = parcel.readLong()
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<OrderDetails> {
        override fun createFromParcel(parcel: Parcel): OrderDetails {
            return OrderDetails(parcel)
        }

        override fun newArray(size: Int): Array<OrderDetails?> {
            return arrayOfNulls(size)
        }
    }


}