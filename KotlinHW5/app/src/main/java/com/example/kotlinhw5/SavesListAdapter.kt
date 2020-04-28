package com.example.kotlinhw5

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SavesListAdapter(
    private val newsList: List<News>,
    private val listener: MainAdapter.ItemClickListener?,
    private val fragmentLikeListener: MainAdapter.FragmentLikeListener?
) :
    RecyclerView.Adapter<SavesListAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(
            parent.context
        )
            .inflate(
                R.layout.item_news,
                null,
                false
            )
        val params = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = params
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[getItemViewType(position)]
        holder.profilePhoto.setImageResource(news.getProfilePhoto())
        holder.postImage.setImageResource(news.getPostImage())
        holder.author.setText(news.getAuthor())
        val s =
            "<b>" + news.getAuthor().toString() + "</b>" + " " + news.getPostText()
        holder.postText.text = Html.fromHtml(s)
        holder.date.setText(news.getDate())
        holder.likesCnt.setText(news.getLikesCnt().toString() + " likes")
        holder.likeBtn.setImageResource(R.drawable.liked)
        holder.likeBtn.setOnClickListener { fragmentLikeListener?.removeItemLike(news) }
        holder.itemView.setOnClickListener { listener?.ItemClick(position, news) }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var author: TextView
        var likesCnt: TextView
        var postText: TextView
        var date: TextView
        var postImage: ImageView
        var profilePhoto: ImageView
        var likeBtn: ImageView
        var saveBtn: ImageView

        init {
            author = itemView.findViewById(R.id.author)
            likesCnt = itemView.findViewById(R.id.likesCnt)
            postImage = itemView.findViewById(R.id.postImage)
            postText = itemView.findViewById(R.id.postText)
            date = itemView.findViewById(R.id.date)
            profilePhoto = itemView.findViewById(R.id.profilePhoto)
            likeBtn = itemView.findViewById(R.id.likeBtn)
            saveBtn = itemView.findViewById(R.id.saveBtn)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface ItemClickListener {
        fun ItemClick(position: Int, item: News?)
    }

    interface FragmentLikeListener {
        fun removeItemLike(news: News?)
    }

}


