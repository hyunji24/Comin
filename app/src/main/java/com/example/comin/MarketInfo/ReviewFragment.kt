package com.example.comin.MarketInfo
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.comin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_review.view.*

class ReviewFragment : Fragment(){

    private lateinit var auth: FirebaseAuth

    private val db=FirebaseFirestore.getInstance()

    private val text_array=ArrayList<String>()
    private val nickname_array=ArrayList<String>()
    private val rating_array=ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.fragment_review,container,false)


        //어댑터 연결
        val review_adapter=ReviewListAdapter(requireContext(),nickname_array,text_array,rating_array)
        view.listview_review.adapter=review_adapter

        //firebase에서 데이터 받아오기
        db.collection("reviews")
            .get()
            .addOnSuccessListener { result->
                for(document in result) {
                    rating_array.add(document.get("rating") as String)
                    text_array.add(document.get("text") as String)
                    nickname_array.add(document.get("writer") as String)
                }
                review_adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception-> }
        view.write_button.setOnClickListener{
          //  if(auth.currentUser==null) {
           //     Toast.makeText(requireContext(), "회원가입or로그인 해주세요", Toast.LENGTH_LONG).show()
            //} else {
                val intent= Intent(requireContext(),WriteActivity::class.java)
                startActivity(intent)
            //}

        }

        return view
    }
}