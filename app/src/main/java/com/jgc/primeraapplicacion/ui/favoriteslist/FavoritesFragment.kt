package com.jgc.primeraapplicacion.ui.favoriteslist


import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.data.local.PreferencesLocalRepository
import com.jgc.primeraapplicacion.data.remote.RetrofitFactory
import com.jgc.primeraapplicacion.data.remote.RetrofitRemoteRepository

/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment(), FavoritesView {
    private lateinit var presenter: FavoritesPresenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites_movies, container, false)
        setHasOptionsMenu(true)

        val presenter = FavoritesPresenter(this)


        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.deletefav_item -> {
                presenter.onDeleteAllClicked()
                true
            }
            R.id.bytitle_item -> {
                presenter.onOrderTitle()
                Toast.makeText(activity, "BY TITLE Click", Toast.LENGTH_SHORT).show();
                true
            }
            R.id.bydate_item -> {
                presenter.onOrderDateAdded()
                Toast.makeText(activity, "BY DATE Click", Toast.LENGTH_SHORT).show();
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showByDateAdded() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showByTitle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
