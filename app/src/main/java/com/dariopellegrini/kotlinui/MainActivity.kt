package com.dariopellegrini.kotlinui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariopellegrini.kotlinui.fragments.HostFragment
import com.dariopellegrini.kotlinui.views.MainView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frameContainer, HostFragment(MainView()))
            .commit();
    }
}
