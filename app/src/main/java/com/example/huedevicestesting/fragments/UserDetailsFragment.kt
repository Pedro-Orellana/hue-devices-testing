package com.example.huedevicestesting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.huedevicestesting.R
import com.example.huedevicestesting.viewmodels.TestViewModel

class UserDetailsFragment : Fragment() {

    private lateinit var name : TextView
    private lateinit var userName : TextView
    private lateinit var street : TextView
    private lateinit var city : TextView
    private lateinit var lat : TextView
    private lateinit var lon : TextView
    private lateinit var website : TextView
    private lateinit var number : TextView
    private lateinit var company : TextView
    private lateinit var catchPhrase : TextView


    private val viewModel : TestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name = view.findViewById(R.id.user_details_fragment_name_text_view)
        userName = view.findViewById(R.id.user_details_fragment_user_name_text_view)
        street = view.findViewById(R.id.user_details_fragment_street_text_view)
        city = view.findViewById(R.id.user_details_fragment_city_text_view)
        lat = view.findViewById(R.id.user_details_fragment_latitude_text_view)
        lon = view.findViewById(R.id.user_details_fragment_longitude_text_view)
        website = view.findViewById(R.id.user_details_fragment_website_text_view)
        number = view.findViewById(R.id.user_details_fragment_phone_number_text_view)
        company = view.findViewById(R.id.user_details_fragment_company_name_text_view)
        catchPhrase = view.findViewById(R.id.user_details_fragment_catch_phrase_text_view)

        viewModel.getCurrentUserLiveData().observe(viewLifecycleOwner){
            name.text = it.name
            userName.text = it.username
            street.text = it.address.street
            city.text = it.address.city
            lat.text = it.address.geo.lat
            lon.text = it.address.geo.lng
            website.text = it.website
            number.text = it.phone
            company.text = it.company.name
            catchPhrase.text = it.company.catchPhrase
        }

    }

}