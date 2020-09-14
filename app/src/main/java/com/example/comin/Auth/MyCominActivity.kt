package com.example.comin.Auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_my_comin.*


class MyCominActivity : AppCompatActivity() {

    private val db=FirebaseFirestore.getInstance()
    private lateinit var auth:FirebaseAuth //디렉토리경로 아래 uid로 찾기 위해 선언
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_comin)

        auth=FirebaseAuth.getInstance()
        val docRef=db.collection("users").document(auth.currentUser?.uid.toString())
        docRef.get().addOnSuccessListener {documentSnapshot ->

            nickname_area.setText(documentSnapshot.get("nickname").toString())

        }
    }
}