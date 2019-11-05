package com.jgc.primeraapplicacion.ui.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.jgc.primeraapplicacion.R

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {
    private lateinit var nameText: TextView
    private lateinit var imageView: ImageView
    private lateinit var cityText: TextView
    private lateinit var ageText: TextView
    private lateinit var descriptionText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        nameText = view.findViewById(R.id.profile_nameView)
        imageView = view.findViewById(R.id.profile_imageView)
        cityText = view.findViewById(R.id.profile_city)
        ageText = view.findViewById(R.id.profile_age)
        descriptionText = view.findViewById(R.id.profile_description)

        val name = "Valentino Rossi"
        val image = R.drawable.valentino_rossi
        val city = "Tuvullia"
        val age = "40"
        val description = "Lorem Ipsum is simply dummy text of the printing and t" +
                "ypesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                " It has survived not only five centuries, but also the leap into electronic typesetting," +
                " remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset" +
                " sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

        nameText.text = name
        imageView.setImageResource(image)
        cityText.text = city
        ageText.text = age
        descriptionText.text = description

        return view
    }


}
