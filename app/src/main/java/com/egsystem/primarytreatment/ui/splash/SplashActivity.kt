package com.egsystem.primarytreatment.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.egsystem.primarytreatment.R
import com.egsystem.primarytreatment.room.FirstAidItemDao
import com.egsystem.primarytreatment.room.FirstAidItemEntity
import com.egsystem.primarytreatment.ui.home.HomeActivity
import com.egsystem.roomkot.FirstAidItemDatabase

class SplashActivity : AppCompatActivity() {


    lateinit var btn_next: Button
    lateinit var tv_header_title: TextView
    lateinit var tv_sub_title: TextView
    lateinit var iv_logo: ImageView
    lateinit var linear_results: LinearLayout
    lateinit var linear_result1: LinearLayout
    lateinit var linear_result2: LinearLayout
    lateinit var linear_result3: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        init()
        loadAnimations()

//        loadDatabaseAndData()
    }

    private fun loadDatabaseAndData() {
        var database: FirstAidItemDao = FirstAidItemDatabase.getDatabase(application).getDao()

        val insertThread = Thread {
            database.insertData(FirstAidItemEntity(1, "column_item_name1", "column_sub_item_name1", "column_micro_item_name1", "column_item_img_url1", "column_sub_item_img_url1", "column_micro_item_img_url1", "column_micro_item_details1"))
            database.insertData(FirstAidItemEntity(2, "column_item_name2", "column_sub_item_name2", "column_micro_item_name2", "column_item_img_url2", "column_sub_item_img_url2", "column_micro_item_img_url2", "column_micro_item_details2"))
            database.insertData(FirstAidItemEntity(3, "column_item_name3", "column_sub_item_name3", "column_micro_item_name3", "column_item_img_url3", "column_sub_item_img_url3", "column_micro_item_img_url3", "column_micro_item_details3"))
            database.insertData(FirstAidItemEntity(4, "column_item_name4", "column_sub_item_name4", "column_micro_item_name4", "column_item_img_url4", "column_sub_item_img_url4", "column_micro_item_img_url4", "column_micro_item_details4"))
            database.insertData(FirstAidItemEntity(5, "column_item_name5", "column_sub_item_name5", "column_micro_item_name5", "column_item_img_url5", "column_sub_item_img_url5", "column_micro_item_img_url5", "column_micro_item_details5"))
        }
        insertThread.start()


        val getDataThread = Thread {
            Log.d("tagRifat","All Data: "+ database.getAllData())
        }
        getDataThread.start()
    }

    private fun init() {
        btn_next = findViewById(R.id.btn_next)
        tv_header_title = findViewById(R.id.tv_header_title)
        tv_sub_title = findViewById(R.id.tv_sub_title)
        iv_logo = findViewById(R.id.iv_logo)
        linear_results = findViewById(R.id.linear_results)
        linear_result1 = findViewById(R.id.linear_result1)
        linear_result2 = findViewById(R.id.linear_result2)
        linear_result3 = findViewById(R.id.linear_result3)

        btn_next.setOnClickListener{
            val intent = Intent(this@SplashActivity,HomeActivity::class.java)
            intent.putExtra("from_where","SplashActivity")
            startActivity(intent)
        }
    }

    private fun loadAnimations() {
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        val stb = AnimationUtils.loadAnimation(this, R.anim.stb);
        val btt1 = AnimationUtils.loadAnimation(this, R.anim.btt1);
        val btt2 = AnimationUtils.loadAnimation(this, R.anim.btt2);
        val btt3 = AnimationUtils.loadAnimation(this, R.anim.btt3);
        val btt4 = AnimationUtils.loadAnimation(this, R.anim.btt4);


        tv_header_title.startAnimation(ttb)
        tv_sub_title.startAnimation(ttb)
        iv_logo.startAnimation(stb)
        linear_result1.startAnimation(btt1)
        linear_result2.startAnimation(btt2)
        linear_result3.startAnimation(btt3)
        btn_next.startAnimation(btt4)

    }
}