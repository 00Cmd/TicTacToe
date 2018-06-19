package com.example.cmd.tictactoe

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

interface References {
    interface AuthRef { fun getAuthInstance() : FirebaseAuth = FirebaseAuth.getInstance() }

    interface DatabaseRef { fun getDatabaseRef() : DatabaseReference }
}