package com.example.comin.Auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class MyCominActivity : AppCompatActivity() {

    private val db=FirebaseFirestore.getInstance()
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_comin)

       // auth=FirebaseAuth.getInstance()
       // val docRef=db.collection("user").document(auth.currentUser?.uid.toString())
       // docRef.get().addOnSuccessListener {documentSnapshot ->

        //}
    }
}