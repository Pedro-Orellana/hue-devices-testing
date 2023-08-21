package com.example.huedevicestesting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.huedevicestesting.R
import com.example.huedevicestesting.adapters.UsersAdapter
import com.example.huedevicestesting.viewmodels.TestViewModel
import com.google.android.material.button.MaterialButton


class TestFragment : Fragment() {

    private lateinit var getUsersButton : MaterialButton
    private lateinit var usersRecyclerView : RecyclerView
    private val adapter = UsersAdapter()

    private val viewModel : TestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUsersButton = view.findViewById(R.id.test_fragment_make_api_call_button)
        usersRecyclerView = view.findViewById(R.id.test_fragment_users_recycler_view)
        usersRecyclerView.adapter = adapter
        usersRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        getUsersButton.setOnClickListener {
            viewModel.getUsers(adapter)
        }
    }
}