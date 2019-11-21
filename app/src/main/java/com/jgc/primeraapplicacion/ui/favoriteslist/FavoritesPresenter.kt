package com.jgc.primeraapplicacion.ui.favoriteslist

import com.jgc.primeraapplicacion.data.local.FavoritesEntity
import com.jgc.primeraapplicacion.data.local.LocalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesPresenter(
    private val view: FavoritesFragment, private val localRepository: LocalRepository
) {
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
            localRepository.deleteAllFavorites()
            withContext(Dispatchers.Main) {
                init()
            }
        }
    }

    fun onOrderDateAdded() {
        CoroutineScope(Dispatchers.IO).launch {
            val orderByDate = localRepository.getOrderByDate()
            withContext(Dispatchers.Main) {
                view.showByDateAdded(orderByDate)
            }
        }
    }

    fun onOrderTitle() {
        CoroutineScope(Dispatchers.IO).launch {
            val orderByTitle = localRepository.getOrderByTitle()
            withContext(Dispatchers.Main) {
                view.showByTitle(orderByTitle)
            }
        }
    }
}

interface FavoritesView {
    fun listPassed(favoritesEntity: List<FavoritesEntity>)
    fun showDeleteAll(favoritesEntity: List<FavoritesEntity>)
    fun showByDateAdded(favoritesEntity: List<FavoritesEntity>)
    fun showByTitle(favoritesEntity: List<FavoritesEntity>)
    fun openMovieDetail(id: Int)

}