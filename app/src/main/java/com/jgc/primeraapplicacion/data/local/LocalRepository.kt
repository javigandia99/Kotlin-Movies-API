package com.jgc.primeraapplicacion.data.local

interface LocalRepository {
    suspend fun getAllMoviesFavorites(): MutableList<FavoritesEntity>
    suspend fun insertFavorite(favoriteEntry: FavoritesEntity)
    suspend fun checkFavorite(id: Int): Int?
    suspend fun getOrderByDate(): MutableList<FavoritesEntity>
    suspend fun getOrderByTitle(): MutableList<FavoritesEntity>
    suspend fun deleteFavorite(favoriteEntry: FavoritesEntity)
    suspend fun deleteAllFavorites()
}