package com.dariopellegrini.kotlinui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dariopellegrini.kotlinui.constants.matchParent
import com.dariopellegrini.kotlinui.constants.wrapContent
import com.dariopellegrini.kotlinui.fragments.HostFragment
import com.dariopellegrini.kotlinui.ui.*
import com.dariopellegrini.kotlinui.ui.actions.toast
import com.dariopellegrini.kotlinui.ui.dimensions.*
import com.dariopellegrini.kotlinui.views.MainView
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {

    var title by Delegate("Hello")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frameContainer, HostFragment(MainView()))
            .commit();
    }
}

class Delegate(var value: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.value = value
    }
}

class Wrapper<T>(var base: String)