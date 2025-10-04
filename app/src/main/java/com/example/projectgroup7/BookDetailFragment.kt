package com.example.projectgroup7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class BookDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_detail, container, false)

        val bookTitle = arguments?.getString("title")
        val bookCategory = arguments?.getString("category")

        view.findViewById<TextView>(R.id.tv_book_title).text = bookTitle
        view.findViewById<TextView>(R.id.tv_book_category).text = bookCategory

        // Tombol back
        val backButton = view.findViewById<ImageView>(R.id.btn_back)
        backButton.setOnClickListener {
            findNavController().navigateUp() // balik ke fragment sebelumnya
        }

        return view
    }
}
