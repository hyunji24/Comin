package com.example.comin.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.comin.MarketInfo.MarketInfoActivity
import com.example.comin.R
import com.example.comin.Utils.FirebaseUtils
import com.example.comin.Utils.FirebaseUtils.Companion.db
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view:View=inflater.inflate(R.layout.fragment_first,container,false)

        val list_array=arrayListOf<ContentListModel>(
            ContentListModel(R.drawable.fairy1,"강의1번",1,"d"),
            ContentListModel(R.drawable.fairy2,"강의2번",2,"d"),
            ContentListModel(R.drawable.fairy3,"강의3번",3,"d"),
            ContentListModel(R.drawable.fairy4,"강의4번",4,"d"),
            ContentListModel(R.drawable.fairy5,"강의5번",5,"d"),
            ContentListModel(R.drawable.fairy1,"강의6번",6,"d")
        )

        val list_adapter=FirstFragAdapter(requireContext(),list_array)
        view.listview_first_fragment.adapter=list_adapter

        //파이어베이스 업데이트



        db.collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if(documentSnapshot.exists()==true){
                    //data필드가 있을 때
                }else{
                    //data필드가 없을 때
                    val lecture= hashMapOf(
                        "강의1번" to "",
                        "강의2번" to "",
                        "강의3번" to "",
                        "강의4번" to "",
                        "강의5번" to "",
                        "강의6번" to ""

                    )
                    db.collection("zzim")
                        .document(FirebaseUtils.getUid())
                        .set(lecture)
                        .addOnSuccessListener {  }
                        .addOnFailureListener {  }
                }
            }
        view.listview_first_fragment.setOnItemClickListener { adapterView,view,i,l->
            val intent= Intent(requireContext(), MarketInfoActivity::class.java)
            intent.putExtra("title",list_array.get(i).title)
            startActivity(intent)
        }

        return view

    }
}