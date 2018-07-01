package com.example.cmd.tictactoe

import com.example.cmd.tictactoe.room.User
import java.util.ArrayList

object UserHolder {

    private var mList: ArrayList<User>? = null

    init {
        initList()
    }

    private fun initList() {
        if (mList == null) {
            mList = ArrayList()
        }
    }

    //TODO: Create a buffer that checks and adds users to database :)

    public fun addUser(user: User) = mList!!.add(user)

    public fun getUser(userId : String) : User = mList!!.find { it.userId == userId }!!







}