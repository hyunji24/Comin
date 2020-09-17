package com.example.comin.Fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.comin.R

class
FirstFragAdapter (val context: Context, val list:ArrayList<ContentListModel>): BaseAdapter(){
    override fun getView(position: Int, converView: View?, parent: ViewGroup?): View {
        val view:View
        val holder:ViewHolder

        if(converView==null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_item, null)
            holder = ViewHolder()
            holder.view_image1 = view.findViewById(R.id.listview_image)
            holder.view_text1 = view.findViewById(R.id.lv_textview_1)
            holder.view_text2 = view.findViewById(R.id.lv_textview_2)
            holder.view_text3 = view.findViewById(R.id.lv_textview_3)

            view.tag = holder //해당 뷰에 tag로 holder 객체 저장
        }
        else{
            holder=converView.tag as ViewHolder //tag로 저장되어있는 홀더 가져오기
            view=converView

        }
        val item=list[position]
        holder.view_image1?.setImageResource(item.image)
        holder.view_text1?.text=item.title
        return view
    }

    override fun getItem(p0: Int): Any {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }

    private class ViewHolder{ //뷰홀더란 뷰들을 홀더에 꼽아놓듯이 보관하는 객체. 주로 ListView의 효율을 높이기 위해 사용
        //ListView는 스크롤시 안보이는 아이템은 매번 getView로 재호출
        //아이템 내 View들은 매번 findViewById로 재연결(자원낭비)
        //해결을 위해 Viewholder로 한번 생성된 View는 findViewById 재호출 막아서 효율up

        var view_image1 : ImageView?=null
        var view_text1 : TextView?=null
        var view_text2 : TextView?=null
        var view_text3 : TextView?=null

    }

}