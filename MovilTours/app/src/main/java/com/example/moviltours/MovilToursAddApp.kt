package com.example.moviltours

import android.app.Application
import com.google.android.gms.ads.MobileAds

class MovilToursAddApp : Application () {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
    }
}