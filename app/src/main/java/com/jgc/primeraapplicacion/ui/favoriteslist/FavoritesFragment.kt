package com.jgc.primeraapplicacion.ui.favoriteslist


import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.data.local.DatabaseFactory
import com.jgc.primeraapplicacion.data.local.FavoritesEntity
import com.jgc.primeraapplicacion.data.local.RoomLocalRepository
import com.jgc.primeraapplicacion.ui.moviedetail.MovieDetailActivity

/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment(), FavoritesView {

    private lateinit var favoritesMovieAdapter: FavoritesAdapter
    private lateinit var favoritesRecyclerView: RecyclerView
    private lateinit var presenter: FavoritesPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites_movies, container, false)
        setHasOptionsMenu(true)

        val localRepository =
            RoomLocalRepository(DatabaseFactory.getDatabase(this.context!!).favoritesDao())

        presenter = FavoritesPresenter(this, localRepository)
        presenter.init()

        favoritesRecyclerView = view.findViewById(R.id.favorites_recycler_view)
        favoritesRecyclerView.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        favoritesRecyclerView.setHasFixedSize(true)

        favoritesMovieAdapter = FavoritesAdapter {
            presenter.movieClicked(it)
        }
        favoritesRecyclerView.adapter = favoritesMovieAdapter

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

    override fun openMovieDetail(id: Int) {
        val intent = Intent(this.context, MovieDetailActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

    override fun listPassed(favoritesEntity: List<FavoritesEntity>) {
        favoritesMovieAdapter.addFavorites(favoritesEntity)
    }

    override fun showDeleteAll(favoritesEntity: List<FavoritesEntity>) {
        favoritesMovieAdapter.deleteFavorites(favoritesEntity)
        Toast.makeText(activity, "Delete All Favorite Movies Successful!", Toast.LENGTH_SHORT)
            .show()
    }

    override fun showByDateAdded() {
        Toast.makeText(activity, "Order by current time Successful!", Toast.LENGTH_SHORT).show()
    }

    override fun showByTitle() {
        favoritesMovieAdapter.orderByTitle()
        Toast.makeText(activity, "Order by title Successful!", Toast.LENGTH_SHORT).show()
    }
}
