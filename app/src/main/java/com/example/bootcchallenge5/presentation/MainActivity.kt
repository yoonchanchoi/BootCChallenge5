package com.example.bootcchallenge5.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bootcchallenge5.presentation.search.SearchFragment
import com.example.bootcchallenge5.databinding.ActivityMainBinding
import com.example.bootcchallenge5.presentation.bookmark.BookmarkFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter = ViewPagerAdapter(this)
    private val tabTitle = listOf("Search","Bookmark")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupViewpager()
        var keyHash = Utility.getKeyHash(this)
        Log.e("cyc","keyHash-->${keyHash}")

    }

    private fun setupViewpager(){
        adapter.addFragment(SearchFragment())
        adapter.addFragment(BookmarkFragment())
        binding.vp.adapter = adapter
        TabLayoutMediator(binding.tl, binding.vp) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}