package com.example.comin

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class ViewPagerAdapter (private val context: Context):PagerAdapter(){

    private var layoutInflater: LayoutInflater?=null
    val Image=arrayOf(
        R.drawable.ai,R.drawable.css,R.drawable.html
    )

    override fun isViewFromObject(view: View, `object`: Any): Boolean { //페이지가 특정 키와 연관되는지 체크
        return view ===`object`
    }

    override fun getCount(): Int {
        return Image.size //슬라이드가 이미지 몇개로 넘어갈지
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any { //데이터리스트에서 인자로 넘어온 position에 해당하는 아이템항목에 대한 페이지를 생성
        layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v=layoutInflater!!.inflate(R.layout.viewpager_activity,null)
        val image=v.findViewById(R.id.imageview) as ImageView //main Activity아닌 다른데서 이미지나 text찾을땐 이런식으로

        image.setImageResource(Image[position])

        val vp=container as ViewPager
        vp.addView(v,0)
        return v
       // return super.instantiateItem(container, position)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp=container as ViewPager
        val v=`object` as View
        vp.removeView(v)
    }
}
