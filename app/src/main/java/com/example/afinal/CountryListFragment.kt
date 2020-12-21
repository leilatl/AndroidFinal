package com.example.afinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_country_list.view.*


class CountryListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_country_list, container, false)

        view.indiaBtn.setOnClickListener {
            val action = CountryListFragmentDirections.toCategory("in")
            Navigation.findNavController(view).navigate(action)
        }
        view.usaBtn.setOnClickListener {
            val action = CountryListFragmentDirections.toCategory("us")
            Navigation.findNavController(view).navigate(action)
        }
        view.australiaBtn.setOnClickListener {
            val action = CountryListFragmentDirections.toCategory("au")
            Navigation.findNavController(view).navigate(action)
        }
        view.russiaBtn.setOnClickListener {
            val action = CountryListFragmentDirections.toCategory("ru")
            Navigation.findNavController(view).navigate(action)
        }
        view.franceBtn.setOnClickListener {
            val action = CountryListFragmentDirections.toCategory("fr")
            Navigation.findNavController(view).navigate(action)
        }
        view.ukBtn.setOnClickListener {
            val action = CountryListFragmentDirections.toCategory("gb")
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }


}