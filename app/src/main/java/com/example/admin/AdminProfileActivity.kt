package com.example.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.admin.databinding.ActivityAdminProfileBinding
import com.example.admin.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AdminProfileActivity : AppCompatActivity() {
    private val binding : ActivityAdminProfileBinding by lazy {
        ActivityAdminProfileBinding.inflate(layoutInflater)
    }
    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var adminReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        adminReference = database.reference.child("user")

        binding.backButton.setOnClickListener {
            finish()
        }
        binding.saceInforButton.setOnClickListener{
            updateUserData()
        }
        binding.name.isEnabled = false
        binding.address.isEnabled = false
        binding.email.isEnabled = false
        binding.phone.isEnabled = false
        binding.password.isEnabled = false
        binding.saceInforButton.isEnabled = false

        var isEnable = false
        binding.editBtn.setOnClickListener {
            isEnable = ! isEnable
            binding.name.isEnabled = isEnable
            binding.address.isEnabled = isEnable
            binding.email.isEnabled = isEnable
            binding.phone.isEnabled = isEnable
            binding.password.isEnabled = isEnable

            if (isEnable){
                binding.name.requestFocus()
            }
            binding.saceInforButton.isEnabled = isEnable
        }
        retrieveUserData()
    }



    private fun retrieveUserData() {
        val currentUserUid = auth.currentUser?.uid
        if (currentUserUid!= null){
            val userReference = adminReference.child(currentUserUid)
            userReference.addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        var ownerName = snapshot.child("name").getValue()
                        var email = snapshot.child("email").getValue()
                        var password = snapshot.child("password").getValue()
                        var address = snapshot.child("address").getValue()
                        var phone = snapshot.child("phone").getValue()

                        setDataToTextView(ownerName, email, password, address, phone)
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
        }

    }

    private fun setDataToTextView(
        ownerName: Any?,
        email: Any?,
        password: Any?,
        address: Any?,
        phone: Any?
    ) {
        binding.name.setText(ownerName.toString())
        binding.email.setText(email.toString())
        binding.password.setText(password.toString())
        binding.phone.setText(phone.toString())
        binding.address.setText(address.toString())
    }
    private fun updateUserData() {
        var updateName = binding.name.text.toString()
        var updatedEmail = binding.email.text.toString()
        var updatedpsasword = binding.password.text.toString()
        var updatePhone = binding.phone.text.toString()
        var updatedAddress = binding.address.text.toString()
        val currentUser = auth.currentUser?.uid
        if(currentUser != null){
            val userReference = adminReference.child(currentUser)
            userReference.child("name").setValue(updateName)
            userReference.child("email").setValue(updatedEmail)
            userReference.child("password").setValue(updatedpsasword)
            userReference.child("phone").setValue(updatePhone)
            userReference.child("name").setValue(updatedAddress)
            Toast.makeText(this, "Profile Updated Success Full", Toast.LENGTH_SHORT).show()
            auth.currentUser?.updateEmail(updatedEmail)
            auth.currentUser?.updatePassword(updatedpsasword)
        }else{
            Toast.makeText(this, "Profile Updated Failed", Toast.LENGTH_SHORT).show()
        }
    }
}