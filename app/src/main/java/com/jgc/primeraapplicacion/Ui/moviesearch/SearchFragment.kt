package com.jgc.primeraapplicacion.ui.moviesearch


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.model.Movie
import com.jgc.primeraapplicacion.ui.moviedetail.MovieDetailActivity
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment(), MovieSearchView {

    lateinit var movieSearchAdapter: MovieSearchAdapter
    lateinit var movieRecyclerView: RecyclerView
    lateinit var searchButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        movieRecyclerView = view.findViewById(R.id.movieSearch_RecyclerView)
        searchButton = view.findViewById(R.id.search_button)
        val presenter = MovieSearchPresenter(this)

        movieRecyclerView.layoutManager = LinearLayoutManager(this.context)
        movieRecyclerView.setHasFixedSize(true)

        movieSearchAdapter = MovieSearchAdapter {
            presenter.movieClicked(it)
        }
        movieRecyclerView.adapter = movieSearchAdapter

        searchButton.setOnClickListener {
            val searchmovie = search_edit_text.text.toString()
            presenter.searchClicked(searchmovie)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        Log.e("1", "-----------------------------------------ERROR MOVIE SEARCH")
    }

    override fun showEmpty() {
        movieSearch_RecyclerView.visibility = View.GONE
    }


}
