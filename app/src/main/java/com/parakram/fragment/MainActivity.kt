package com.parakram.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.parakram.fragment.fragments.AreaFragment
import com.parakram.fragment.fragments.SumFragment

class MainActivity : AppCompatActivity() {
    private lateinit var btnSumFragment: Button
    private lateinit var btnAreaFragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSumFragment = findViewById(R.id.btnSum)
        btnAreaFragment = findViewById(R.id.btnArea)

        btnAreaFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearContainer, SumFragment())
                addToBackStack(null)
                commit()
            }
        }
        btnSumFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearContainer, AreaFragment())
                addToBackStack(null)
                commit()
            }
        }
    }
}