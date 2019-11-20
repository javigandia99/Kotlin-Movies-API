package com.jgc.primeraapplicacion.ui.favoriteslist

import com.jgc.primeraapplicacion.data.local.FavoritesEntity
import com.jgc.primeraapplicacion.data.local.LocalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesPresenter(
    private val view: FavoritesFragment, private val localRepository: LocalRepository) {
    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            val listFavorites = localRepository.getAllMoviesFavorites()
            withContext(Dispatchers.Main) {
                view.listPassed(listFavorites)
            }
        }
    }

    fun movieClicked(movie: FavoritesEntity) {
        view.openMovieDetail(movie.id)
    }

    fun onDeleteAllClicked() {
        CoroutineScope(Dispatchers.IO).launch {
            //localRepository.deleteFavorite(FavoritesEntity() )
            withContext(Dispatchers.Main) {}
            view.showDeleteAll()
        }
    }

    fun onOrderDateAdded() {
        view.showByDateAdded()
    }

    fun onOrderTitle() {
        view.showByTitle()
    }
}

interface FavoritesView {
    fun showDeleteAll()
    fun showByDateAdded()
    fun showByTitle()
    fun openMovieDetail(id: Int)
    fun listPassed(favoritesEntity: List<FavoritesEntity>)
}