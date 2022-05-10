package com.example.moviltours.Ad

import android.app.Application
import com.google.android.gms.ads.MobileAds

class MovilToursAdApp : Application() {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
    }
}