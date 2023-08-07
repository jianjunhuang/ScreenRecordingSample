package com.serenegiant.screenrecordingsample

import android.os.AsyncTask

class Stopwatch(private val listener: UpdateListener) : Runnable {

    @Volatile
    private var start = 0L
    private var thread = Thread(this)
    var isStart = false
        private set

    private var isInit = true

    init {
        thread.start()
    }

    fun start() {
        start = 0L
        isStart = true
    }

    fun stop() {
        isStart = false
    }

    fun release() {
        isInit = false
    }

    interface UpdateListener {
        fun onUpdate(time: Long)
    }

    override fun run() {
        while (isInit) {
            while (isStart) {
                listener.onUpdate(start)
                Thread.sleep(100)
                start += 100L
            }
        }
    }

    fun getTime(): Long {
        return start
    }
}