package com.example.huedevicestesting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.huedevicestesting.R
import com.example.huedevicestesting.adapters.UsersAdapter
import com.example.huedevicestesting.viewmodels.TestViewModel
import com.google.android.material.button.MaterialButton


class NoCoroutinesTestFragment : Fragment() {

    private lateinit var getUsersButton : MaterialButton
    private lateinit var usersRecyclerView: RecyclerView

    private val viewModel : TestViewModel by activityViewModels()
    private lateinit var navController: NavController
    private val adapter = UsersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        navController = findNavController()
        return inflater.inflate(R.layout.fragment_no_coroutines_test, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setCardClickListener {
            viewModel.setCurrentUser(it)
            navController.navigate(R.id.action_noCoroutinesTestFragment_to_userDetailsFragment)
        }

        getUsersButton = view.findViewById(R.id.no_coroutines_fragment_make_api_call_button)
        usersRecyclerView = view.findViewById(R.id.no_coroutines_fragment_users_recycler_view)
        usersRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        usersRecyclerView.adapter = adapter


        getUsersButton.setOnClickListener {
            viewModel.getUsersWithNoCoroutines(adapter)
        }
    }

}