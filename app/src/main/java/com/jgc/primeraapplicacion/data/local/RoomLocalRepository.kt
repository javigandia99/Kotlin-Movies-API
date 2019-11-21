package com.jgc.primeraapplicacion.data.local

class RoomLocalRepository(private val favoritesDao: FavoritesDao) : LocalRepository {

    override suspend fun getAllMoviesFavorites(): MutableList<FavoritesEntity> {
        return favoritesDao.getAllMoviesFavorites()
    }

    override suspend fun insertFavorite(favoriteEntry: FavoritesEntity) {
        val movieDB = FavoritesEntity(
            id = favoriteEntry.id,
            poster_path = favoriteEntry.poster_path,
            title = favoriteEntry.title,
            release_date = favoriteEntry.release_date,
            adult = favoriteEntry.adult,
            popularity = favoriteEntry.popularity,
            vote_average = favoriteEntry.vote_average,
            date_added = favoriteEntry.date_added
        )
        favoritesDao.insertFavorite(movieDB)
    }

    override suspend fun checkFavorite(id: Int): Int? {
        return favoritesDao.checkFavorite(id)
    }

    override suspend fun getOrderByDate(): MutableList<FavoritesEntity> {
        return favoritesDao.getOrderByDate()
    }

    override suspend fun getOrderByTitle(): MutableList<FavoritesEntity> {
        return favoritesDao.getOrderByTitle()
    }

    override suspend fun deleteFavorite(favoriteEntry: FavoritesEntity) {
        favoritesDao.deleteFavorite(favoriteEntry)
    }
/*
    override suspend fun deleteAllFavorites(): MutableList<FavoritesEntity> {
        return favoritesDao.deleteAllFavorites()
    }
*/
}