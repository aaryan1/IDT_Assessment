package com.tks.idt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tks.idt.R
import com.tks.idt.adapter.StateAdapter
import com.tks.idt.model.State
import com.tks.idt.viewmodel.StateViewModel

class StateListFragment : Fragment() {
   // private lateinit var viewModel: StateViewModel
   private var selectedState: State? = null
   private val viewModel: StateViewModel by activityViewModels()
    private lateinit var stateAdapter: StateAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_state_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel = ViewModelProvider(this)[StateViewModel::class.java]
        //viewModel = ViewModelProvider(requireActivity())[StateViewModel::class.java]

        //val nextButton = view.findViewById<View>(R.id.nextScreen)
        val stateListRecyclerView = view.findViewById<RecyclerView>(R.id.stateList)
        val filteredStateListRecyclerView = view.findViewById<RecyclerView>(R.id.filteredStateList)
        val searchBox = view.findViewById<EditText>(R.id.searchBox)

        stateAdapter = StateAdapter(selectedState,viewModel.states.value ?: listOf()) { state ->
            viewModel.selectState(state)
          //  findNavController().navigate(R.id.action_stateListFragment_to_stateDetailFragment)
        }

        stateListRecyclerView.adapter = stateAdapter
        stateListRecyclerView.layoutManager = LinearLayoutManager(context)

        searchBox.addTextChangedListener {
            viewModel.filterStates(it.toString())
        }

        viewModel.states.observe(viewLifecycleOwner) { states ->
            stateAdapter = StateAdapter(stateAdapter.selectedState,states) { state -> viewModel.selectState(state)
            }
            filteredStateListRecyclerView.adapter = stateAdapter
        }

       /* nextButton.setOnClickListener {
          //write the code here to navigate to the next screen

        }*/
    }
}
