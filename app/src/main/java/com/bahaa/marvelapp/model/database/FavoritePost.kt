package com.bahaa.marvelapp.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FAVORITE_POST_TABLE")
data class FavoritePost(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val imageUrl: String,
    val name: String,
)
