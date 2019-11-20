package com.dariopellegrini.kotlinui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dariopellegrini.kotlinui.R
import com.dariopellegrini.kotlinui.kview.KView
import com.dariopellegrini.kotlinui.ui.extensions.configure
import kotlinx.android.synthetic.main.fragment_host.*

class HostFragment(private val scene: KView) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_host, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        containerLayout.configure(scene)
    }
}
