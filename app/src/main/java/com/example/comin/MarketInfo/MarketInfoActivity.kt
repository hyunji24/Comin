package com.example.comin.MarketInfo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Toast
import androidx.fragment.app.replace
import com.example.comin.R
import com.example.comin.Utils.FirebaseUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_market_info.*

class MarketInfoActivity : AppCompatActivity() {

    private val auth:FirebaseAuth=FirebaseAuth.getInstance()
    private val db=FirebaseFirestore.getInstance()
    //매번 액티비티에서 불러오기 귀찮으면 FirebaseUtils.kt 파일만들어서 선언해놓고 갖다써도됨
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_info)

        lecture_text.text=intent.getStringExtra("title")

        //찜여부 확인
        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot->
                if(documentSnapshot.get(intent.getStringExtra("title").toString())==true){
                    header_zzim.text="♥"
                }
            }
            .addOnFailureListener {  }


        zzim.setOnClickListener {
            //이미 찜 되어있을 때
            if (header_zzim.text.equals("♥")) {

                header_zzim.text="♡"
                header_zzim.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25F)

                db.collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .update(intent.getStringExtra("title").toString(),"")
                    .addOnSuccessListener {
                        Toast.makeText(this,"성공",Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,"실패",Toast.LENGTH_LONG).show()
                    }


            } else {
                //이미 찜 되어있지 않을때
                header_zzim.text = "♥"
                header_zzim.setTextColor(Color.RED)
                header_zzim.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25F)
                db.collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .update(intent.getStringExtra("title").toString(), true)
                    .addOnSuccessListener {
                        Toast.makeText(this, "성공", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "실패", Toast.LENGTH_SHORT).show()
                    }
            }
        }

        supportFragmentManager.beginTransaction().replace(R.id.fragment_area,ContentFragment()).commit()
        //fragment를 액티비티에 부착만 해두면 사실 할수 있는게 없음
        //액티비티와 프래그먼트의 중간에서 서로를 이어주는 역할: supportFragmentManager
        //.commit()을 반드시 붙여줘야 transaction 작업 가능


        figure_1.setOnClickListener {
            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_area,ContentFragment()).commit()
        }
        figure_2.setOnClickListener {
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25F)
            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_area,InfoFragment()).commit()
        }
        figure_3.setOnClickListener {
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)
            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_area,ReviewFragment()).commit()
        }
    }
}