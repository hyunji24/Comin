package com.example.comin.Zzim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comin.R
import com.example.comin.Utils.FirebaseUtils
import com.example.comin.Utils.FirebaseUtils.Companion.db
import kotlinx.android.synthetic.main.activity_zzim.*

class ZzimActivity : AppCompatActivity() {

    val array_list=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zzim)


        db.collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if(documentSnapshot.get("강의1번")!=""){
                    array_list.add("강의1번")
                }
                if(documentSnapshot.get("강의2번")!=""){
                    array_list.add("강의2번")
                }
                if(documentSnapshot.get("강의3번")!=""){
                    array_list.add("강의3번")
                }
                if(documentSnapshot.get("강의4번")!=""){
                    array_list.add("강의4번")
                }
                if(documentSnapshot.get("강의5번")!=""){
                    array_list.add("강의5번")
                }
                if(documentSnapshot.get("강의6번")!=""){
                    array_list.add("강의6번")
                }

                val zzimAdapter=ZzimmAdapter(this,array_list)
                zzim_listview.adapter=zzimAdapter
            }
            .addOnFailureListener {  }


    }
}