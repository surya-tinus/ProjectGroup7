package com.example.projectgroup7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectgroup7.R
import com.example.projectgroup7.Book

class BookAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_book_title)
        val cover: ImageView = itemView.findViewById(R.id.iv_book_cover)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.title.text = book.title

        Glide.with(holder.itemView.context)
            .load(book.coverUrl)
            .into(holder.cover)
    }

    override fun getItemCount(): Int = books.size
}