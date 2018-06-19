package com.example.cmd.tictactoe

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.cmd.tictactoe.R.id.*

class ProfileActivity : AppCompatActivity(),InitFragment,References.AuthRef {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)
        startFragment(ProfileFragment.getInstance())
    }

    override fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(profileContainer,fragment)
                .addToBackStack(fragment.tag).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            settings -> startActivity(Intent(this,UserSettingsActivity::class.java))
            logout -> getAuthInstance().signOut()
        }
        return false
    }



}


