package com.example.water_drinking_whale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportFragmentManager.beginTransaction()) {
            val homeFragment = HomeFragment()
            replace(R.id.container, homeFragment)
            commit()
        }

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeTab -> {
                    with(supportFragmentManager.beginTransaction()) {
                        val homeFragment = HomeFragment()
                        replace(R.id.container, homeFragment)
                        commit()
                    }

                    return@setOnNavigationItemSelectedListener true
                }
                R.id.logTab -> {
                    with(supportFragmentManager.beginTransaction()) {
                        val logFragment = LogFragment()
                        replace(R.id.container, logFragment)
                        commit()
                    }

                    return@setOnNavigationItemSelectedListener true
                }
                R.id.noticeTab-> {
                    with(supportFragmentManager.beginTransaction()) {
                        val noticeFragment = NoticeFragment()
                        replace(R.id.container, noticeFragment)
                        commit()
                    }

                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }
}