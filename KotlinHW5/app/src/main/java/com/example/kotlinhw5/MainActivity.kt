package com.example.kotlinhw5

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*


class MainActivity : AppCompatActivity(), MainAdapter.FragmentButtonListener,
    MainAdapter.FragmentLikeListener, SavesListAdapter.FragmentLikeListener {
    private var pager: LockableViewPager? = null
    private var pagerAdapter: PagerAdapter? = null
    var f1: Fragment = NewsList()
    var f2: Fragment = SavesList()
    var list: MutableList<Fragment> =
        ArrayList()
    var bottomNavigationView: BottomNavigationView? = null

    @TargetApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        list.add(f1)
        list.add(f2)
        pager = findViewById(R.id.pager)
        pager?.setSwipable(false)
        pagerAdapter = SlidePagerAdapter(supportFragmentManager, list)
        pager?.setAdapter(pagerAdapter)
        bottomNavigationView?.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when (item.itemId) {
                        R.id.home -> {
                            pager?.setCurrentItem(0, false)
                            bottomNavigationView?.getMenu()?.findItem(R.id.save)
                                ?.setIcon(R.drawable.ic_save)
                        }
                        R.id.save -> {
                            pager?.setCurrentItem(1, false)
                            item.setIcon(R.drawable.ic_favorite)
                        }
                    }
                    return false
                }
            })
    }

    override fun myClick(news: News?, option: Int) {
        val fragment =
            supportFragmentManager.findFragmentById(R.id.pager)
        if (option == 1) news?.let { (fragment as SavesList?)?.saveNews(it) } else news?.let {
            (fragment as SavesList?)?.removeNews(
                it
            )
        }
    }

    override fun removeItemLike(news: News?) {
        (f1 as NewsList).removeLike(news)
        if (news != null) {
            (f2 as SavesList).removeLike(news)
        }
    }
}
