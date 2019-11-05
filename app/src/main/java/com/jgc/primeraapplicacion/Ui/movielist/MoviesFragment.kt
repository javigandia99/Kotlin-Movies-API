package com.jgc.primeraapplicacion.ui.movielist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.model.Movie
import kotlinx.android.synthetic.main.activity_movie_list.*

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       /* recycler_view.apply {
            layoutManager = LinearLayoutManager(this)
            adapter = MoviesAdapter(movieList)
            addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
            setHasFixedSize(true)
        }
*/
        val view = inflater.inflate(R.layout.fragment_movies, container, false)


        return view
    }


}
