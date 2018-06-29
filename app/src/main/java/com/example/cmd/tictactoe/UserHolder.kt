package com.example.cmd.tictactoe

import java.util.ArrayList

class UserHolder {

    private var mList: ArrayList<User>? = null

    init {
        initList()
    }


    companion object {
        private var mHolder: UserHolder? = null

        val instance: UserHolder
            get() {
                if (mHolder == null) {
                    mHolder = UserHolder()
                }
                return mHolder!!
            }
    }

    private fun initList() {
        if (mList == null) {
            mList = ArrayList()
        }
    }




    //TODO: Create a buffer that checks and adds users to database :)

    public fun addUser(user:User) = mList!!.add(user)

    public fun getUser(userId : String) : User = mList!!.find { it.userId == userId }!!







}