package com.jgc.primeraapplicacion.data.local

interface LocalRepository {
    suspend fun getAllMoviesFavorites(): MutableList<FavoritesEntity>
    suspend fun insertFavorite(favoriteEntry: FavoritesEntity)
}