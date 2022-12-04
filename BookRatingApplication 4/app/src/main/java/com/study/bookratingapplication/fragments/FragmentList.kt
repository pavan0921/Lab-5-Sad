package com.study.bookratingapplication.fragments

import android.os.Bundle
import com.study.bookratingapplication.fragments.FragmentList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.study.bookratingapplication.Books
import com.study.bookratingapplication.BooksAdapter
import com.study.bookratingapplication.R

class FragmentList : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var books : ArrayList<Books>? = null

        val  bookList = arguments?.getSerializable("movie_list")
        books = bookList as ArrayList<Books>

        val recyclerview = view.findViewById<RecyclerView>(R.id.recycler_view)
                recyclerview.layoutManager = LinearLayoutManager(requireContext())
        val adapter = BooksAdapter(books!!, requireContext())
        recyclerview.adapter = adapter
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): FragmentList {
            val fragment = FragmentList()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}