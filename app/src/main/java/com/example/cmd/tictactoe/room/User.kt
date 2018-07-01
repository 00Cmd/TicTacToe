package com.example.cmd.tictactoe.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "usersTable")
data class User(@PrimaryKey(autoGenerate = true) var id: Long?,
                @ColumnInfo(name = "email") var email: String,
                @ColumnInfo(name = "firstname") var firstname: String,
                @ColumnInfo(name = "lastname") var lastname: String,
                @ColumnInfo(name = "password") var password: String,
                @ColumnInfo(name = "imageUrl") var imageUrl: String) {
    constructor() : this(null,"","","","","")


}