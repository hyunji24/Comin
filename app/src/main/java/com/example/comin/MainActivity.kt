package com.example.comin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.comin.Auth.LoginActivity
import com.example.comin.Auth.MyCominActivity
import com.example.comin.Zzim.ZzimActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom.*

class MainActivity : AppCompatActivity() {

    internal lateinit var viewpager:ViewPager //viewpager 만들어주고

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

val img=arrayOf(
    R.drawable.ai,
    R.drawable.css,
    R.drawable.html,
    R.drawable.id,
    R.drawable.jpg,
    R.drawable.js,
    R.drawable.mp4,
    R.drawable.php,
    R.drawable.pdf,
    R.drawable.psd,
    R.drawable.png,
    R.drawable.tiff

)

val text=arrayOf(
    "ai","ai","ab","ca","dg","at","as","ag","ai","it","lg","at"
)

val gridViewAdapter=GridViewAdapter(this,img,text)
gridview.adapter=gridViewAdapter
        gridview.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, LectureActivity::class.java)
            startActivity(intent)
        }
viewpager=findViewById(R.id.viewpager) as ViewPager
val adapter=ViewPagerAdapter(this)
viewpager.adapter=adapter

        zzim_lectures.setOnClickListener {
            val intent=Intent(this,ZzimActivity::class.java)
            startActivity(intent)
        }
        my_page.setOnClickListener {
            if(auth.currentUser==null){
                val intent=Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            else{
               val intent=Intent(this, MyCominActivity::class.java)
                startActivity(intent)
            }

        }
}
}