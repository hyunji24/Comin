package com.example.comin.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.comin.MarketInfo.MarketInfoActivity
import com.example.comin.R
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view:View=inflater.inflate(R.layout.fragment_first,container,false)

        val list_array=arrayListOf<ContentListModel>(
            ContentListModel("a","b",1,"d"),
            ContentListModel("a","b",1,"d"),
            ContentListModel("a","b",1,"d"),
            ContentListModel("a","b",1,"d"),
            ContentListModel("a","b",1,"d"),
            ContentListModel("a","b",1,"d")
        )

        val list_adapter=FirstFragAdapter(requireContext(),list_array)
        view.listview_first_fragment.adapter=list_adapter

        view.listview_first_fragment.setOnItemClickListener { adapterView,view,i,l->
            val intent= Intent(requireContext(), MarketInfoActivity::class.java)
            startActivity(intent)
        }

        return view

    }
}