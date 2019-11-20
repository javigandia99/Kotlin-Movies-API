package com.jgc.primeraapplicacion.ui.profile


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.data.local.PreferenceLoginLocalRepository
import com.jgc.primeraapplicacion.ui.login.LoginActivity

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment(), ProfileView {
    private lateinit var nameText: TextView
    private lateinit var imageView: ImageView
    private lateinit var cityText: TextView
    private lateinit var ageText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var presenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        setHasOptionsMenu(true)
        nameText = view.findViewById(R.id.profile_nameView)
        imageView = view.findViewById(R.id.profile_imageView)
        cityText = view.findViewById(R.id.profile_city)
        ageText = view.findViewById(R.id.profile_age)
        descriptionText = view.findViewById(R.id.profile_description)

        val localRepository = PreferenceLoginLocalRepository(
            this.context!!.getSharedPreferences(
                "login_preference",
                Context.MODE_PRIVATE
            )
        )
        presenter = ProfilePresenter(this, localRepository)

        val name = "Valentino Rossi"
        val image = R.drawable.valentino_rossi
        val city = "Tuvullia"
        val age = "40"
        val description = "Lorem Ipsum is simply dummy text of the printing and t" +
                "setting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                " It has survived not only five centuries, but also the leap into electronic typesetting," +
                " remaining essentially unchanged. It was popularised in the 1960s with the release of set" +
                " sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

        nameText.text = name
        imageView.setImageResource(image)
        cityText.text = city
        ageText.text = age
        descriptionText.text = description

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.profile_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout_item -> {
                presenter.logoutClicked()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun goToLogin() {
        val intent = Intent(this.context, LoginActivity::class.java)
        //FLAG_ACTIVITY_CLEAR_TOP tells system to clear all the activities on the top of LoginActivity
        //FLAG_ACTIVITY_NEW_TASK tells the system, create a new Task and set LoginActivity as the first activity
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        activity!!.finish()

    }
}
