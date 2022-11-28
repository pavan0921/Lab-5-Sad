package com.study.bookratingapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BooksAdapter(private val booksList: List<Books>, var context: Context) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.books_item, parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val books = booksList[position]
        holder.bookName?.text = books.name
        holder.bookGerne?.text = books.gerne
        holder.bookRead?.text = books.status
        holder.ratingBar?.rating = books.rating!!.toFloat()
        holder.linearLayout?.setOnClickListener {

            val intent = Intent(context, BookDetailsActivity::class.java)
            intent.putExtra("book_name", books.name)
            intent.putExtra("book_gerne", books.gerne)
            intent.putExtra("book_status", books.status)
            intent.putExtra("book_rating", books.rating)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return booksList.size
    }


    inner class BooksViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var bookName : TextView? = null
        var bookGerne : TextView? = null
        var bookRead : TextView? = null
        var ratingBar : RatingBar? = null
        var linearLayout : LinearLayout? = null

        init {
            bookName = itemView.findViewById(R.id.tv_book_name)
            bookGerne = itemView.findViewById(R.id.tv_gerne)
            bookRead = itemView.findViewById(R.id.tv_bookread)
            ratingBar = itemView.findViewById(R.id.ratingBar)
            linearLayout = itemView.findViewById(R.id.ll_item)
        }

    }

}