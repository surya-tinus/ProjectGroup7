package com.example.projectgroup7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BookAdapter
    private val bookList = mutableListOf<Book>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (bookList.isEmpty()) {
            bookList.addAll(
                listOf(
                    Book("Book 1", "Romance", "https://picsum.photos/200"),
                    Book("Book 2", "Horror", "https://picsum.photos/201"),
                    Book("Book 3", "Comedy", "https://picsum.photos/202")
                )
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val greetingTextView = view.findViewById<TextView>(R.id.tv_greeting)
        val currentHour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
        val greeting = when (currentHour) {
            in 5..11 -> "Good Morning,"
            in 12..16 -> "Good Afternoon,"
            in 17..20 -> "Good Evening,"
            else -> "Good Night,"
        }
        greetingTextView.text = greeting

        recyclerView = view.findViewById(R.id.rv_new_books)
        adapter = BookAdapter(bookList) { selectedBook ->
            val bundle = Bundle().apply {
                putString("title", selectedBook.title)
                putString("category", selectedBook.category)
                putString("image", selectedBook.imageUrl)
            }

            // navigasi via Navigation Component
            requireView().findNavController()
                .navigate(R.id.action_homeFragment_to_bookDetailFragment, bundle)
        }


        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = adapter
    }
}
