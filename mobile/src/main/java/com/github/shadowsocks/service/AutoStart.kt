package com.github.shadowsocks.service


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.github.shadowsocks.startServiceCompat

class AutoStart : BroadcastReceiver() {
    override fun onReceive(context: Context, arg1: Intent) {
        val intent = Intent(context, BackgroundService::class.java)
        context.startServiceCompat(intent)
        Log.i("Autostart", "started")
    }
}