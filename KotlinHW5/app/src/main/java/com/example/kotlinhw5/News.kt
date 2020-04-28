package com.example.kotlinhw5

import android.os.Parcel
import android.os.Parcelable

class News() : Parcelable {

    var newsList: List<News> = ArrayList()
    var saves: List<News> = ArrayList()
    private var id = 0
    private var author: String? = null
    private var date: String? = null
    private var profilePhoto = 0
    private var likesCnt = 0
    private var postImage = 0
    private var postText: String? = null
    private var likeBtn = 0
    private var isLiked = false

    constructor(parcel: Parcel) : this() {
        this.id = id
        this.author = author
        this.date = date
        this.profilePhoto = profilePhoto
        this.likesCnt = likesCnt
        this.postImage = postImage
        this.postText = postText
    }

    fun isLiked(): Boolean {
        return isLiked
    }

    fun setLiked(liked: Boolean) {
        isLiked = liked
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getLikeBtn(): Int {
        return likeBtn
    }

    fun setLikeBtn(likeBtn: Int) {
        this.likeBtn = likeBtn
    }

    fun getAuthor(): String? {
        return author
    }

    fun setAuthor(author: String?) {
        this.author = author
    }

    fun getDate(): String? {
        return date
    }

    fun setDate(date: String?) {
        this.date = date
    }

    fun getProfilePhoto(): Int {
        return profilePhoto
    }

    fun setProfilePhoto(profilePhoto: Int) {
        this.profilePhoto = profilePhoto
    }

    fun getLikesCnt(): Int {
        return likesCnt
    }

    fun setLikesCnt(likesCnt: Int) {
        this.likesCnt = likesCnt
    }

    fun getPostImage(): Int {
        return postImage
    }

    fun setPostImage(postImage: Int) {
        this.postImage = postImage
    }

    fun getPostText(): String? {
        return postText
    }

    fun setPostText(postText: String?) {
        this.postText = postText
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(newsList)
        parcel.writeTypedList(saves)
        parcel.writeInt(id)
        parcel.writeString(author)
        parcel.writeString(date)
        parcel.writeInt(profilePhoto)
        parcel.writeInt(likesCnt)
        parcel.writeInt(postImage)
        parcel.writeString(postText)
        parcel.writeInt(likeBtn)
        parcel.writeByte(if (isLiked) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<News> {
        lateinit var newsList: ArrayList<News>

        override fun createFromParcel(parcel: Parcel): News {
            return News(parcel)
        }

        override fun newArray(size: Int): Array<News?> {
            return arrayOfNulls(size)
        }
    }
}
