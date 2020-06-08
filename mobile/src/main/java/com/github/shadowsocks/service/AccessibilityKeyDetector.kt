package com.github.shadowsocks.service

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.KeyEvent
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import com.github.shadowsocks.Core
import timber.log.Timber

class AccessibilityKeyDetector : AccessibilityService() {
    private val TAG = "AccessKeyDetector"
    public override fun onKeyEvent(event: KeyEvent): Boolean {
        Timber.d("Key pressed via accessibility is: " + event.keyCode)
        if (event.action == KeyEvent.ACTION_UP) {
            if (event.keyCode == KeyEvent.KEYCODE_PROG_GREEN) {
                Core.startService()
                Toast.makeText(applicationContext, "VPN On", Toast.LENGTH_SHORT).show()
            } else if (event.keyCode == KeyEvent.KEYCODE_PROG_RED) {
                Core.stopService()
                Toast.makeText(applicationContext, "VPN Off", Toast.LENGTH_SHORT).show()
            }

        }

        //This allows the key pressed to function normally after it has been used by your app.
        return super.onKeyEvent(event)
    }

    override fun onServiceConnected() {
        Log.d(TAG, "Service connected")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        Log.d(TAG, "onAccessibilityEvent $event")

    }

    override fun onInterrupt() {
        Log.d(TAG, "onAccessibilityEvent")

    }
}