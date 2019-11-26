package com.jgc.primeraapplicacion.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM moviesFavorites")
    fun getAllMoviesFavorites(): MutableList<FavoritesEntity>

    @Query("SELECT id FROM moviesFavorites WHERE id Like :id")
    fun checkFavorite(id: Int): Int?

    @Query("SELECT * FROM moviesFavorites ORDER BY dateadded ")
    fun getOrderByDate(): MutableList<FavoritesEntity>

    @Query("SELECT * FROM moviesFavorites ORDER BY title")
    fun getOrderByTitle(): MutableList<FavoritesEntity>

    @Insert
    fun insertFavorite(vararg favoriteEntry: FavoritesEntity)

    @Delete
    fun deleteFavorite(favoriteEntry: FavoritesEntity)

    @Query("DELETE FROM moviesFavorites")
    fun deleteAllFavorites()
    
}