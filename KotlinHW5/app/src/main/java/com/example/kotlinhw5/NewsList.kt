package com.example.kotlinhw5

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import com.example.kotlinhw5.News

class NewsList : Fragment() {
    var recyclerView: RecyclerView? = null
    private var mainAdapter: MainAdapter? = null
    private var listener: MainAdapter.ItemClickListener? = null
    private var fragmentButtonListener: MainAdapter.FragmentButtonListener? = null
    private var fragmentLikeListener: MainAdapter.FragmentLikeListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater
            .inflate(R.layout.page, container, false) as ViewGroup
        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView?.setLayoutManager(LinearLayoutManager(getActivity()))
        listener = object : MainAdapter.ItemClickListener {
            override fun ItemClick(position: Int, item: News?) {
                val intent = Intent(getActivity(), DetailsActivity::class.java)
                intent.putExtra("news", item)
                startActivity(intent)
            }
        }
        fragmentButtonListener = object : MainAdapter.FragmentButtonListener {
            override fun myClick(news: News?, option: Int) {
                (getActivity() as MainActivity).myClick(news, option)
            }
        }
        fragmentLikeListener = object : MainAdapter.FragmentLikeListener {
            override fun removeItemLike(news: News?) {
                (getActivity() as MainActivity).removeItemLike(news)
            }
        }
        mainAdapter =
            MainAdapter(newsGenerator() as MutableList<News>, listener, fragmentButtonListener, fragmentLikeListener)
        recyclerView?.setAdapter(mainAdapter)
        return rootView
    }


    private fun newsGenerator(): List<News>? {
        val items: MutableList<News> = ArrayList()
        val news1 = News(
            1,
            "brfootball",
            "April 17, 2019",
            R.drawable.profile2,
            623462,
            R.drawable.post1,
            """
                Why do you love football?
                What do you see in it?
                Why not watch another sport
                Like Rugby, Golf, or Cricket?
                
                Well let me answer that my friend
                And put your mind at rest
                I love the beautiful game
                Because it's simply the best
                
                No other sport is as exciting
                No other comes anywhere near
                Football can create passion
                And lots of atmosphere#FootballIsLife #LoveFootball #PlayFootball
                """.trimIndent()
        )
        items.add(news1)
        val news2 = News(
            2,
            "brfootball",
            "September 1, 2019",
            R.drawable.profile2,
            2361512,
            R.drawable.post2,
            """
                Well...
                You can
                kick it you can catch
                it you can bounce it - all
                around. You can grab it you can
                pat it you can roll it - on the ground.
                """.trimIndent()
        )
        items.add(news2)
        val news3 = News(
            3,
            "brfootball",
            "May 2, 2019",
            R.drawable.profile2,
            3213141,
            R.drawable.post3,
            """
                In a pub all the channels were on football
                But there was a guy with no interest at all
                He was asked; who’s winning?
                He replied; dunno who’s playing?
                He only knew when his beer was due for a call
                """.trimIndent()
        )
        items.add(news3)
        val news4 = News(
            4,
            "brfootball",
            "May 31, 2018",
            R.drawable.profile2,
            6234234,
            R.drawable.post4,
            """
                I can’t forget those days baby
                No I can't forget at all
                When you used to love me madly
                When I was only your doll!
                
                """.trimIndent()
        )
        items.add(news4)
        val news5 = News(
            5,
            "brfootball",
            "April 29, 2019",
            R.drawable.profile2,
            5235233,
            R.drawable.post5,
            """
                You have loose character
                I have known it later
                It has driven me crazy
                Baby I feel so lonely!
                """.trimIndent()
        )
        items.add(news5)
        val news6 = News(
            6,
            "brfootball",
            "March 27, 2019",
            R.drawable.profile2,
            25332,
            R.drawable.post6,
            """
                Baby I am not bad at all
                But you treat me like a football
                That’s why now I curse you
                But I pray for you too!
                """.trimIndent()
        )
        items.add(news6)
        val news7 = News(
            7,
            "brfootball",
            "March 15, 2019",
            R.drawable.profile2,
            24234253,
            R.drawable.post7,
            """
                Baby now I hate you
                As much as I love you
                You are like my favorite food
                Baby I am not very good!
                """.trimIndent()
        )
        items.add(news7)
        val news8 = News(
            8,
            "brfootball",
            "November 20, 2018",
            R.drawable.profile2,
            6457456,
            R.drawable.post8,
            """
                YOU can keep your antique silver and your statuettes of bronze,
                Your curios and tapestries so fine,
                But of all your treasures rare there is nothing to compare
                With this patched up, wornout football pal o’ mine.
                Just a patchedup wornout football, yet how it clings!
                I live again my happier days in thoughts that football brings.
                """.trimIndent()
        )
        items.add(news8)
        val news9 = News(
            9,
            "brfootball",
            "January 3",
            R.drawable.profile2,
            8474,
            R.drawable.post9,
            """
                Now rule number one
                Football is made of eleven strong men
                When one or two are naughty
                you may still get away
                with playing nine or ten
                
                
                """.trimIndent()
        )
        items.add(news9)
        val news10 = News(
            10,
            "brfootball",
            "January 6",
            R.drawable.profile2,
            10716,
            R.drawable.post10,
            """
                Rule number two
                When a member of your crew
                hits the ball into the net
                A goal is scored
                that I can place a bet
                For I am very sure
                """.trimIndent()
        )
        items.add(news10)
        val news11 = News(
            11,
            "433",
            "March 6",
            R.drawable.profile1,
            18857,
            R.drawable.post11,
            "Come On You Gunners\uD83E" +
                    "#YaGunnersYa #COYG #RedAndWhite"
        )
        items.add(news11)
        val news12 = News(
            12,
            "polymathematica",
            "February 20",
            R.drawable.profile1,
            25809,
            R.drawable.post12,
            """
                Rule number three
                The maximum number of players
                you can substitute is three
                It does not cost a dime
                It is totally free
                """.trimIndent()
        )
        items.add(news12)
        val news13 = News(
            13,
            "433",
            "January 12",
            R.drawable.profile1,
            6792,
            R.drawable.post13,
            """
                Rule number four
                There are rules you must comply with
                When a team commits an offense
                named a foul
                before the game can commence
                A small advantage has to be given
                to the otherside
                """.trimIndent()
        )
        items.add(news13)
        val news14 = News(
            14,
            "433",
            "January 12",
            R.drawable.profile1,
            7300,
            R.drawable.post14,
            """
                Rule number five
                A freekick
                is given after a foul
                Sometimes awarded after
                unnecessary dives
                """.trimIndent()
        )
        items.add(news14)
        val news15 = News(
            15,
            "433",
            "January 8",
            R.drawable.profile1,
            944583,
            R.drawable.post15,
            """
                Listen to Pogba and Dybala
                @paulpogba @dybala #StayAtHome #Pogba #Dybala #433
                """.trimIndent()
        )
        items.add(news15)
        val news16 = News(
            16,
            "433",
            "December 3, 2019",
            R.drawable.profile1,
            3016,
            R.drawable.post16,
            """
                Listen to Pogba and Dybala
                @paulpogba @dybala #StayAtHome #Pogba #Dybala #433
                """.trimIndent()
        )
        items.add(news16)
        val news17 = News(
            17,
            "433",
            "December 9, 2019",
            R.drawable.profile1,
            9393,
            R.drawable.post17,
            "Simeone says hello to y'all"
        )
        items.add(news17)
        val news18 = News(
            18,
            "433",
            "June 7, 2019",
            R.drawable.profile1,
            2260,
            R.drawable.post18,
            "We are all Simeone sometimes.."
        )
        items.add(news18)
        val news19 = News(
            19,
            "433",
            "April 19, 2019",
            R.drawable.profile1,
            113189,
            R.drawable.post19,
            "Watch your feet! Atletico defeated Liverpool!" +
                    "#Atletico #CelebrateLikeASimeone"
        )
        items.add(news19)
        val news20 = News(
            20,
            "433",
            "December 23, 2018",
            R.drawable.profile1,
            135996,
            R.drawable.post20,
            "Ballerina be like"
        )
        items.add(news20)
        return items
    }

    private fun News(i: Int, s: String, s1: String, profile2: Int, i1: Int, post1: Int, trimIndent: String) {
    }

    fun removeLike(news: News?) {
        mainAdapter!!.removeLike(news!!)
    }
    private fun <E> MutableList<E>.add(element: Unit) {

    }
}
