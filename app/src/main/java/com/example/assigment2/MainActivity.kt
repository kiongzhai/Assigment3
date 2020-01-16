package com.example.assigment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_compare.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.compare -> {
                println("compare pressed")
                replaceFragment(CompareFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.recommendation ->{
                println("recommendation pressed")
                replaceFragment(RecommendationFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.picker ->{
                println("picker pressed")
                replaceFragment(PickerFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(CompareFragment())

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
