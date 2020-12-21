package com.example.afinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_category.view.*

class categoryFragment : Fragment() {
    val args: categoryFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        view.businessBtn.setOnClickListener {
            val action = categoryFragmentDirections.actionCategoryFragmentToNewsListFragment(args.country, "business")
            Navigation.findNavController(view).navigate(action)
        }

        view.entertainmentBtn.setOnClickListener {
            val action = categoryFragmentDirections.actionCategoryFragmentToNewsListFragment(args.country, "entertainment")
            Navigation.findNavController(view).navigate(action)
        }

        view.generalBtn.setOnClickListener {
            val action = categoryFragmentDirections.actionCategoryFragmentToNewsListFragment(args.country, "general")
            Navigation.findNavController(view).navigate(action)
        }

        view.healthBtn.setOnClickListener {
            val action = categoryFragmentDirections.actionCategoryFragmentToNewsListFragment(args.country, "health")
            Navigation.findNavController(view).navigate(action)
        }

        view.scienceBtn.setOnClickListener {
            val action = categoryFragmentDirections.actionCategoryFragmentToNewsListFragment(args.country, "science")
            Navigation.findNavController(view).navigate(action)
        }

        view.sportsBtn.setOnClickListener {
            val action = categoryFragmentDirections.actionCategoryFragmentToNewsListFragment(args.country, "sports")
            Navigation.findNavController(view).navigate(action)
        }

        view.techBtn.setOnClickListener {
            val action = categoryFragmentDirections.actionCategoryFragmentToNewsListFragment(args.country, "technology")
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }

}