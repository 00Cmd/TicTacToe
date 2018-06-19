package com.example.cmd.tictactoe

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView

class SettingsFragment : Fragment() {

    private val scrollView : ScrollView ? = null


    val TAG = "SettingsFragment"
    companion object {
        fun getInstance() : SettingsFragment {
            return SettingsFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.settings_layout,container,false)

    }
}