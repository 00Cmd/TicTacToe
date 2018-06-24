package com.example.cmd.tictactoe

class User() {
    //TODO: Change to K,V pairs and create a util class that holds all the users
    var email: String = ""
    var firstname:  String = ""
    var lastname: String  = ""
    var password: String  = ""
    var image: String  = ""
    var userId: String  = ""

    constructor(email:String,
                firstname: String,
                lastname: String,
                password: String,
                image: String, userId : String) : this() {
        this.email = email
        this.firstname = firstname
        this.lastname = lastname
        this.password = password
        this.image = image
        this.userId = userId
    }

}