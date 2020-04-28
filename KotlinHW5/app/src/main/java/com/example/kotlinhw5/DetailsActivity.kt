package com.example.kotlinhw5

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailsActivity : AppCompatActivity() {

    private var back: ImageButton? = null
    private var likeBtn: ImageView? = null
    private var saveBtn: ImageView? = null
    private var profilePhoto: ImageView? = null
    private var author: TextView? = null
    private var postImage: ImageView? = null
    private var postText: TextView? = null
    private var date: TextView? = null
    private var likesCnt: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        back = findViewById(R.id.back)
        likeBtn = findViewById(R.id.likeBtn)
        saveBtn = findViewById(R.id.saveBtn)
        profilePhoto = findViewById(R.id.profilePhoto)
        author = findViewById(R.id.author)
        postImage = findViewById(R.id.postImage)
        postText = findViewById(R.id.postText)
        date = findViewById(R.id.date)
        likesCnt = findViewById(R.id.likesCnt)
        val news = intent.getSerializableExtra("news") as News
        profilePhoto?.setImageResource(news.getProfilePhoto())
        postImage?.setImageResource(news.getPostImage())
        author?.setText(news.getAuthor())
        val s = news.getAuthor().toString() + " " + news.getPostText()
        postText?.setText(Html.fromHtml(s))
        date?.setText(news.getDate())
        likesCnt?.setText(news.getLikesCnt().toString() + " likes")
        back?.setOnClickListener(View.OnClickListener { onBackPressed() })
        likeBtn?.setOnClickListener(View.OnClickListener {
            if (news.getLikeBtn() === R.drawable.like) {
                likeBtn?.setImageResource(R.drawable.liked)
                news.setLikeBtn(R.drawable.liked)
            } else {
                likeBtn?.setImageResource(R.drawable.like)
                news.setLikeBtn(R.drawable.like)
            }
        })
    }
}