package com.example.huedevicestesting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.huedevicestesting.viewmodels.HueViewModel
import com.example.huedevicestesting.R
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment() {

    private lateinit var findBridgeButton : MaterialButton
    private lateinit var bridgeRecyclerView : RecyclerView

    private val viewModel : HueViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findBridgeButton = view.findViewById(R.id.home_fragment_find_bridge_button)
        bridgeRecyclerView = view.findViewById(R.id.home_fragment_bridge_recycler_view)

        findBridgeButton.setOnClickListener {
            //TODO make call to find hue bridges in this network
        }
    }

}