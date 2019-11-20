package com.jgc.primeraapplicacion.data.local

import androidx.room.*

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM moviesfavorites")
    fun getAllMoviesFavorites(): MutableList<FavoritesEntity>

    @Query("SELECT * FROM moviesfavorites ORDER BY date ")
    fun getOrderByDate(): MutableList<FavoritesEntity>

    @Query("SELECT * FROM moviesfavorites ORDER BY title")
    fun getOrderByTitle(): MutableList<FavoritesEntity>

    @Insert
    fun insertFavorite(favoriteEntry: FavoritesEntity)

    @Delete
    fun deleteFavorite(favoriteEntry: FavoritesEntity)
}