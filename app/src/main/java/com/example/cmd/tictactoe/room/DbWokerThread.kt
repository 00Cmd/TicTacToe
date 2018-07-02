package com.example.cmd.tictactoe.room

import android.os.HandlerThread
import android.os.Looper
import java.util.logging.Handler

class DbWokerThread(threadName :String) : HandlerThread(threadName) {
    private lateinit var mWorkerHandler: Handler
//
//    override fun onLooperPrepared() {
//        super.onLooperPrepared()
//        mWorkerHandler = Handler()
//    }
//
//    fun postTask(task: Runnable) {
//        mWorkerHandler.post(task)
//    }
}