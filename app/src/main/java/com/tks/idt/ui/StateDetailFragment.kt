package com.tks.idt.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.tks.idt.R
import com.tks.idt.viewmodel.StateViewModel

class StateDetailFragment : Fragment() {
    //private lateinit var viewModel: StateViewModel
    private val viewModel: StateViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_state_detail, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // viewModel = ViewModelProvider(requireActivity())[StateViewModel::class.java]
       Log.d("Coming","dvbdvh v")

        val stateNameTextView = view.findViewById<TextView>(R.id.stateName)
        val populationTextView = view.findViewById<TextView>(R.id.population)
        val countiesTextView = view.findViewById<TextView>(R.id.counties)
        val sumCountyPopulationTextView = view.findViewById<TextView>(R.id.sumCountyPopulation)

        viewModel.selectedState.observe(viewLifecycleOwner) {
            stateNameTextView.text = " StateName ${it.state}"
            populationTextView.text = "Population: ${it.population}"
            countiesTextView.text = "Counties: ${it.counties}"
            //sumCountyPopulationTextView.text=it.

        }
    }
}