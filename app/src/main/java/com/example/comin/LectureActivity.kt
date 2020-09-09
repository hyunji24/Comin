package com.example.comin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.comin.Fragment.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_lecture2.*
import kotlinx.android.synthetic.main.custom_tab.view.*

class LectureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture2)

        val fragmentAdapter=FragmentAdapter(supportFragmentManager)
        list_viewpager.adapter=fragmentAdapter

        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("AI")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("CSS")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("ABC")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("HI")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("GOG")))
        list_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        //탭에서 손가락으로 스와이프해도 탭이 따라서 움직임


        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (p0 != null) {
                    list_viewpager.currentItem=p0.position
                }
            }

        })

    }

    private fun createTabView(tabName:String): View {
        //탭레이아웃안에 custom tab들을 하나씩 만들어주는 역할
        val tabView= LayoutInflater.from(baseContext).inflate(R.layout.custom_tab,null)
        tabView.txt_name.text=tabName

        return tabView
    }
}