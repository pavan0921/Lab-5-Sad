package com.study.bookratingapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    var btn_addreview : Button? = null
    var linear_layout : LinearLayout? = null
    var welcone_layout : LinearLayout? = null
    var tv_Bookname : TextView? = null
    var tv_Bookgerne : TextView? = null
    var tv_Bookread : TextView? = null
    var ratingabar : RatingBar? = null
    var arrayList : ArrayList<Books>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        arrayList = ArrayList<Books>();
        ratingabar = findViewById<RatingBar>(R.id.st_rBar)

        btn_addreview = findViewById<Button>(R.id.btn_addreview)
        linear_layout = findViewById<LinearLayout>(R.id.linear_layout)
        welcone_layout = findViewById<LinearLayout>(R.id.welcone_layout)
        tv_Bookname = findViewById<TextView>(R.id.tv_book)
        tv_Bookgerne = findViewById<TextView>(R.id.tv_gerne)
        tv_Bookread = findViewById<TextView>(R.id.tv_bookread)
        linear_layout?.visibility = View.GONE
        welcone_layout?.visibility = View.VISIBLE

        btn_addreview?.setOnClickListener {
            val intent = Intent(this@MainActivity, RateBooksActivity::class.java)
            resultLauncher.launch(intent)
        }

    }


    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes

            val bookDetails = Books(
                result.data?.getStringExtra("book_name"),
                result.data?.getStringExtra("book_rating"),
                result.data?.getStringExtra("book_gerne"),
                result.data?.getStringExtra("read_status")
            )

            arrayList?.add(bookDetails!!)

            Toast.makeText(this, "Review Added", Toast.LENGTH_SHORT).show()

            val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)
            recyclerview.layoutManager = LinearLayoutManager(this)
            val adapter = BooksAdapter(arrayList!!, this)
            recyclerview.adapter = adapter

            tv_Bookname?.text = result.data?.getStringExtra("book_name")
            tv_Bookgerne?.text = result.data?.getStringExtra("book_gerne")
            tv_Bookread?.text =  result.data?.getStringExtra("read_status")
            ratingabar?.rating = result.data?.getStringExtra("book_rating")?.toFloat()!!

            welcone_layout?.visibility = View.GONE
            linear_layout?.visibility = View.VISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.setting_menu_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_item -> {
                val intent = Intent(this@MainActivity, SettingsActivity::class.java)
                startActivity(intent)
            }
        }

        return true
    }

}