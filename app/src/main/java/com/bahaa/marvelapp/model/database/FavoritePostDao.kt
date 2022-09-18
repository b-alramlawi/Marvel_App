package com.bahaa.marvelapp.model.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface FavoritePostDao {

    @Insert
    fun insert(favoritePost: FavoritePost): Completable

    @Delete
    fun delete(favoritePost: FavoritePost): Completable

    @Query("SELECT * FROM FAVORITE_POST_TABLE ORDER BY id DESC")
    fun getAllPosts(): Observable<List<FavoritePost>>

}