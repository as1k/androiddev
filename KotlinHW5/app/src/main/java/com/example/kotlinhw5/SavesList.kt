package com.example.kotlinhw5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinhw5.MainAdapter.*
import java.util.*


class SavesList : Fragment() {
    var recyclerView: RecyclerView? = null
    private var adapter: SavesListAdapter? = null
    private var newsList: MutableList<News>? = null
    private var listener: ItemClickListener? = null
    private var fragmentLikeListener: FragmentLikeListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater
            .inflate(R.layout.page, container, false) as ViewGroup
        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView?.setLayoutManager(LinearLayoutManager(activity))
        listener = object : ItemClickListener {
            override fun ItemClick(position: Int, item: News?) {
                val intent = Intent(activity, DetailsActivity::class.java)
                intent.putExtra("news", item)
                startActivity(intent)
            }
        }
        fragmentLikeListener = object : FragmentLikeListener {
            override fun removeItemLike(news: News?) {
                (activity as MainActivity?)!!.removeItemLike(news)
            }
        }
        newsList = ArrayList()
        adapter = SavesListAdapter(newsList as ArrayList<News>, listener, fragmentLikeListener)
        recyclerView?.setAdapter(adapter)
        return rootView
    }

    fun saveNews(news: News) {
        newsList!!.add(news)
        recyclerView!!.adapter!!.notifyItemInserted(newsList!!.size - 1)
    }

    fun removeNews(news: News) {
        if (newsList!!.indexOf(news) == 0) {
            newsList!!.remove(news)
        } else {
            val position = newsList!!.indexOf(news)
            newsList!!.remove(news)
            recyclerView!!.adapter!!.notifyItemRemoved(position)
        }
    }

    fun removeLike(news: News) {
        val n = newsList!!.indexOf(news)
        removeNews(news)
        adapter?.notifyItemRemoved(n)
    }
}
