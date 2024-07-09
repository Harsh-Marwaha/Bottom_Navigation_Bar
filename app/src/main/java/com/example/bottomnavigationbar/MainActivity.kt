package com.example.bottomnavigationbar

import android.content.ClipData.Item
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView



lateinit var frameLayout: FrameLayout
lateinit var bottomNavigationView: BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

         var navHome = HomeFragment()
         var navSearch = SearchFragment()
         var navNotification = NotificationnFragment()
         var navProfile = ProfileFragment()


        replace(navHome)

        bottomNavigationView=findViewById(R.id.bottomNavigationView)
        frameLayout=findViewById(R.id.frameLayout)

        bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId)
            {
                R.id.navHome->replace(navHome)
                R.id.navSearch->replace(navSearch)
                R.id.navNotification->replace(navNotification)
                R.id.navProfile->replace(navProfile)
            }
            true
        }

    }

    fun replace(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }

}