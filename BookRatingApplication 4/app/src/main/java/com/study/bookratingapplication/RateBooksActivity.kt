package com.study.bookratingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class RateBooksActivity : AppCompatActivity() {

    var book_gerne : String? = null
    var book_name : String? = null
    var book_rating : String? = null
    var read_status : String? = "NO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_books)

        val bookslist = Common.gernelist
        val spinner = findViewById<Spinner>(R.id.spinner_gerne)
        val rBar = findViewById<RatingBar>(R.id.rBar)
        val edittext = findViewById<EditText>(R.id.ed_bookname)
        val btn = findViewById<Button>(R.id.btn_submit)
        val radioGrp = findViewById<RadioGroup>(R.id.radio_group)

        radioGrp.setOnCheckedChangeListener { group, checkedId ->

            if(checkedId == 2131231064){
                read_status = "YES"
            }else{
                read_status = "NO"
            }

        }

        // access the spinner
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bookslist)

            spinner.adapter = adapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    if(position == 0){
                        book_gerne = null
                    }else{
                        book_gerne = bookslist[position].toString()
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    book_gerne =""
                }
            }
        }



        btn.setOnClickListener {

            if (rBar != null) {
                book_rating = rBar.rating.toString()
            }

            if(edittext?.text?.isEmpty() != null){
                book_name = edittext?.text?.toString()
           }

            if(book_name ==  null){
                Toast.makeText(applicationContext, "Mention name", Toast.LENGTH_LONG).show()
            }else if(book_rating == null){
                Toast.makeText(applicationContext, "Mention rating", Toast.LENGTH_LONG).show()
            }else if(book_gerne == null){
                Toast.makeText(applicationContext, "Mention gerne", Toast.LENGTH_LONG).show()
            }else{

                val resultIntent = Intent()
                resultIntent.putExtra("book_name", book_name)
                resultIntent.putExtra("book_rating", book_rating)
                resultIntent.putExtra("book_gerne", book_gerne)
                resultIntent.putExtra("read_status", read_status)
                setResult(RESULT_OK, resultIntent)
                finish()

            }
        }

    }
}