package com.example.projectgroup7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_new_books)
        adapter = BookAdapter(bookList)

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3) // Grid 3 kolom
        recyclerView.adapter = adapter

        // dummy data
        bookList.addAll(
            listOf(
                Book("Book 1", "Romance", "https://picsum.photos/200"),
                Book("Book 2", "Horror", "https://picsum.photos/201"),
                Book("Book 3", "Comedy", "https://picsum.photos/202")
            )
        )
        adapter.notifyDataSetChanged()
    }
}
