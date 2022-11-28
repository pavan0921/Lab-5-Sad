package com.study.bookratingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView

class BookDetailsActivity : AppCompatActivity() {

    var tv_Bookname : TextView? = null
    var tv_Bookgerne : TextView? = null
    var tv_Bookread : TextView? = null
    var ratingabar : RatingBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val intent = getIntent();

        val name = intent?.getStringExtra("book_name")
        val rating = intent?.getStringExtra("book_rating")
        val gerne = intent?.getStringExtra("book_gerne")
        val status = intent?.getStringExtra("read_status")

        ratingabar = findViewById<RatingBar>(R.id.st_rBar)
        tv_Bookname = findViewById<TextView>(R.id.tv_book)
        tv_Bookgerne = findViewById<TextView>(R.id.tv_gerne)
        tv_Bookread = findViewById<TextView>(R.id.tv_bookread)

        tv_Bookname?.text = name
        tv_Bookgerne?.text = gerne
        tv_Bookread?.text =  status
        ratingabar?.rating = rating?.toFloat()!!


    }
}