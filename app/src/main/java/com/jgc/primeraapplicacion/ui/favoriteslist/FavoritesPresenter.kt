package com.jgc.primeraapplicacion.ui.favoriteslist

class FavoritesPresenter(private val view: FavoritesFragment) {

    fun onDeleteAllClicked() {
        view.deleteAll()
    }

    fun onOrderDateAdded() {
        view.showByDateAdded()
    }

    fun onOrderTitle() {
        view.showByTitle()
    }
}

interface FavoritesView {
    fun deleteAll()
    fun showByDateAdded()
    fun showByTitle()
}