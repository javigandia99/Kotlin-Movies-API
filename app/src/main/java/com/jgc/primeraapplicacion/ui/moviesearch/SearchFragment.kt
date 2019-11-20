package com.jgc.primeraapplicacion.ui.moviesearch

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.data.local.PreferenceLoginLocalRepository
import com.jgc.primeraapplicacion.data.remote.RemoteRepository
import com.jgc.primeraapplicacion.data.remote.RetrofitFactory
import com.jgc.primeraapplicacion.data.remote.RetrofitRemoteRepository
import com.jgc.primeraapplicacion.model.Movie
import com.jgc.primeraapplicacion.ui.moviedetail.MovieDetailActivity
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment(), MovieSearchView, SearchView.OnQueryTextListener {

    private lateinit var movieSearchAdapter: MovieSearchAdapter
    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var presenter: MovieSearchPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        movieRecyclerView = view.findViewById(R.id.movieSearch_RecyclerView)
        searchView = view.findViewById(R.id.search_view)

        val remoteRepository: RemoteRepository =
            RetrofitRemoteRepository(RetrofitFactory.getMovieApi())
        val localRepository = PreferenceLoginLocalRepository(this.activity!!.getSharedPreferences("login_preference",Context.MODE_PRIVATE))
        presenter = MovieSearchPresenter(this, localRepository, remoteRepository)

        searchView.setOnQueryTextListener(this@SearchFragment)

        movieRecyclerView.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        movieRecyclerView.setHasFixedSize(true)

        movieSearchAdapter = MovieSearchAdapter {
            presenter.movieClicked(it)
        }
        movieRecyclerView.adapter = movieSearchAdapter

        return view
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        presenter.searchClicked(newText!!)
        return false
    }

    override fun showMovies(movies: List<Movie>) {
        movieSearchAdapter.addMovies(movies)
        movieSearch_RecyclerView.visibility = View.VISIBLE
    }

    override fun openMovieDetail(id: Int) {
        val intent = Intent(this.context, MovieDetailActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

    override fun showError() {
        Toast.makeText(
            activity,
            "Error: We could not have showed you the movies",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun showEmpty() {
        movieSearch_RecyclerView.visibility = View.GONE
    }


}
