package com.jgc.primeraapplicacion.data.local

class RoomLocalRepository(private val database: FavoritesDatabase) : LocalRepository {
    private val favoritesDao = database.favoritesDao()

    override suspend fun insertFavorite(favoriteEntry: FavoritesEntity) {
            favoritesDao.insertFavorite(favoriteEntry)
    }

    override suspend fun getAllMoviesFavorites(): MutableList<FavoritesEntity> {
        val favoriteList = database.favoritesDao().getAllMoviesFavorites()

        return favoriteList
    }

}