package com.example.kotlinhw5

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinhw5.News.CREATOR.newsList
import com.example.kotlinhw5.SavesListAdapter.NewsViewHolder


class MainAdapter internal constructor(
    var newsList: MutableList<News>,
    listener: ItemClickListener?,
    fragmentButtonListener: FragmentButtonListener?,
    fragmentLikeListener: FragmentLikeListener?
) :
    RecyclerView.Adapter<NewsViewHolder>() {
    var main_list: MutableList<News>
    private var listener: ItemClickListener?
    private var fragmentButtonListener: FragmentButtonListener?
    private var fragmentLikeListener: FragmentLikeListener?

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {
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
        return this.NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SavesListAdapter.NewsViewHolder, position: Int) {
        val news: News = newsList.get(getItemViewType(position))
        holder.profilePhoto.setImageResource(news.getProfilePhoto())
        holder.postImage.setImageResource(news.getPostImage())
        holder.author.text = news.getAuthor()
        val s =
            "<b>" + news.getAuthor().toString() + "</b>" + " " + news.getPostText()
        holder.postText.text = Html.fromHtml(s)
        holder.date.text = news.getDate()
        holder.likesCnt.text = news.getLikesCnt().toString() + " likes"
        if (news.isLiked() === true) holder.likeBtn.setImageResource(R.drawable.liked) else holder.likeBtn.setImageResource(
            R.drawable.like
        )
        holder.likeBtn.setOnClickListener {
            if (fragmentButtonListener != null) {
                if (news.isLiked()) {
                    holder.likeBtn.setImageResource(R.drawable.like)
                    //fragmentButtonListener.myClick(news, 2);
                    fragmentLikeListener!!.removeItemLike(news)
                    news.setLiked(false)
                } else {
                    holder.likeBtn.setImageResource(R.drawable.liked)
                    fragmentButtonListener?.myClick(news, 1)
                    news.setLiked(true)
                }
            }
        }
        holder.itemView.setOnClickListener { listener?.ItemClick(position, news) }
    }

    override fun getItemCount(): Int {
        return newsList?.size
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

    interface FragmentButtonListener {
        fun myClick(news: News?, option: Int)
    }

    interface ItemClickListener {
        fun ItemClick(position: Int, item: News?)
    }

    interface FragmentLikeListener {
        fun removeItemLike(news: News?)
    }

    fun removeLike(news: News) {
        var n: Int = News.newsList.indexOf(news)
        news.setLiked(false)
        news.setLikeBtn(R.drawable.like)
        News.newsList.set(n, news)
        main_list[n] = news
        this.notifyItemChanged(n)
    }

    init {
        newsList = newsList
        main_list = newsList
        this.listener = listener
        this.fragmentButtonListener = fragmentButtonListener
        this.fragmentLikeListener = fragmentLikeListener
    }
}

