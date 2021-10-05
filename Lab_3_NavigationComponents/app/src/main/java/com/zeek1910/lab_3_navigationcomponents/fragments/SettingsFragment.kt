package com.zeek1910.lab_3_navigationcomponents.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.zeek1910.lab_3_navigationcomponents.R


class SettingsFragment : Fragment() {

    private lateinit var buttonLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin = view.findViewById(R.id.button)
        buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_loginFragment)
        }
    }
}