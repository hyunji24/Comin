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
import kotlinx.android.synthetic.main.fragment_review.view.*

class ReviewFragment : Fragment(){

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.fragment_review,container,false)
        view.write_button.setOnClickListener{
            //if(auth.currentUser==null)
            //    Toast.makeText(requireContext(),"회원가입or로그인 해주세요", Toast.LENGTH_LONG).show()
            val intent= Intent(requireContext(),WriteActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}