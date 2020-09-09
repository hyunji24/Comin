package com.example.comin.MarketInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.comin.MainActivity
import com.example.comin.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {

    private lateinit var rating_num:String
    private val db= FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        rating_area.setOnRatingBarChangeListener{ratingBar,fl,b->
            rating_num=fl.toString()

        }
        writing_button.setOnClickListener {
            val form= hashMapOf(
                "test" to text_input_area.text.toString(),
                "rating" to rating_num
            )
            db.collection("reviews").add(form)
                .addOnSuccessListener { Toast.makeText(this,"성공",Toast.LENGTH_LONG).show()
                val intent= Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                .addOnFailureListener{Toast.makeText(this,"실패",Toast.LENGTH_LONG).show()}

        }
    }
}