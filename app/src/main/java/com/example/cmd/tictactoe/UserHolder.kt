package com.example.cmd.tictactoe

class UserHolder {
    lateinit var mUsers : ArrayList<User>

    init {
        initList()
    }

    companion object {
        fun getInstance() : UserHolder {
            return UserHolder()
        }
    }

    //TODO: Find out how init works

    public fun addUser(user:User) = mUsers.add(user)

    public fun getUser(userId : String) : User {
        val user : User = mUsers.find { it.userId == userId }!!
        if (user == null) {
            throw NullPointerException()
        } else {
            return user
        }
    }

    private fun initList() : ArrayList<User> {
        if (!::mUsers.isInitialized) {
            mUsers = ArrayList<User>()
        }
        return mUsers
    }



}