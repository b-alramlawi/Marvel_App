package com.bahaa.marvelapp.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoritePost::class], version = 1)
abstract class FavoritePostDatabase : RoomDatabase() {

    abstract fun postDao(): FavoritePostDao


    companion object {
        private const val DATABASE_NAME = "FavoriteMarvelCharacterPost"

        @Volatile
        private var instance: FavoritePostDatabase? = null

        fun getInstanceWithContext(context: Context): FavoritePostDatabase {
            return instance ?: synchronized(this) {
                buildDatabase(context).also { instance = it }
            }
        }

        fun getInstanceWithoutContext() = instance!!


        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            FavoritePostDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

}