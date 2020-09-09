package com.example.comin.MarketInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.replace
import com.example.comin.R
import kotlinx.android.synthetic.main.activity_market_info.*

class MarketInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_info)

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