package com.adrpien.broadcastapp

import android.content.Intent
import android.content.IntentFilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
Broadcast Receiver pozwala na odbieranie powiadomień z systemu lub innych aplikacji.
Android wysyła powiadomienie do wszysktich aplikacji nasłuchujacych danego wydarzenia.
Nasza aplikacja  również może wysłać takie powiadomienie i inne aplikację mogą je otrzymywać.
Istnieje również local broadcast, do użycia w obrębie naszej aplikacji
1. Utworzyć klasę reprezentującą BroadcastReceiver
    - zaimplementować w niej metodę onReceive
2. Zarejestrować BroadcastReceiver:
    - w aktywności (rejestracja z kontekstem) -  dopóki nasza aktywność istnieje,
    dopóty bedziemy nasłuchiwać w metodzie onResume
    - w pliku manifestu - BroadcastReceiver bedzie nasłuchiwać, nawet gdy aplikacja jest wyłaczona
    (jeśli wydarzenie będzie miało miejsce aplikacja ją uruchomi). W tym celu należy dodać <receiver> </receiver>
    UWAGA! Od API 26 rejestracja w pliku manifest nie działa dla wszystkich wydarzeń!
3. Wyrejestrować BroadcastReceiver w metodzie onPause

BraodcastReceiver nasłuchuje tylko, gdy nasza aplikacja ma miejsce wprowadzania (onResume - onPause)

 */

class MainActivity : AppCompatActivity() {

    lateinit var myBroadcastReceiver: MyBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        myBroadcastReceiver = MyBroadcastReceiver()

        // Receiver register
        // IntentFilter sets, what kind of event we wait for
        registerReceiver(myBroadcastReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(myBroadcastReceiver)
    }
}