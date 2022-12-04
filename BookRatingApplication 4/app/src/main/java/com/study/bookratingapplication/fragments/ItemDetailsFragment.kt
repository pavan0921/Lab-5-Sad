package com.study.bookratingapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.study.bookratingapplication.R

/**
 * A simple [Fragment] subclass.
 * Use the [ItemDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ItemDetailsFragment : Fragment() {

    var tv_Bookname : TextView? = null
    var tv_Bookgerne : TextView? = null
    var tv_Bookread : TextView? = null
    var ratingabar : RatingBar? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name= arguments?.getString("name");
        val gerne= arguments?.getString("gerne");
        val status= arguments?.getString("status");
        val rating= arguments?.getString("rating");

        ratingabar = view.findViewById<RatingBar>(R.id.st_rBar)
        tv_Bookname = view.findViewById<TextView>(R.id.tv_book)
        tv_Bookgerne = view.findViewById<TextView>(R.id.tv_gerne)
        tv_Bookread = view.findViewById<TextView>(R.id.tv_bookread)

        tv_Bookname?.text = name
        tv_Bookgerne?.text = gerne
        tv_Bookread?.text =  status
        ratingabar?.rating = rating?.toFloat()!!

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }
}