package com.adrpien.broadcastapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
         if(intent?.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            Toast.makeText(context, "Airplane  mode changed", Toast.LENGTH_LONG).show()
         }
    }

}