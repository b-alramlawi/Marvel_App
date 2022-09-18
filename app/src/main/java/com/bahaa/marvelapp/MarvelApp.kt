package com.bahaa.marvelapp

import android.app.Application
import com.bahaa.marvelapp.model.database.FavoritePostDatabase

class MarvelApp: Application() {

    override fun onCreate() {
        super.onCreate()
        FavoritePostDatabase.getInstanceWithContext(this.applicationContext)
    }
}