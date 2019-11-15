package com.jgc.primeraapplicacion.ui.favoriteslist


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jgc.primeraapplicacion.R

/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites_movies, container, false)
        setHasOptionsMenu(true)



        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.deletefav_item -> {
                //presenter.logoutClicked()
                true
            }
            R.id.bytitle_item -> {
                //presenter.logoutClicked()
                Toast.makeText(activity, "BY TITLE Click", Toast.LENGTH_SHORT).show();
                true
            }
            R.id.bydate_item -> {
                //presenter.logoutClicked()
                Toast.makeText(activity, "BY DATE Click", Toast.LENGTH_SHORT).show();
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
