package com.tks.idt.adapter

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tks.idt.R
import com.tks.idt.model.State

class StateAdapter(
    var selectedState: State?,
    private val stateList: List<State>,
    private val clickListener: (State) -> Unit
) : RecyclerView.Adapter<StateAdapter.StateViewHolder>() {

    inner class StateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stateName: TextView = itemView.findViewById(R.id.stateName)

        fun bind(state: State) {
            stateName.text = state.state
            itemView.isSelected = state == selectedState
            itemView.setOnClickListener {
                clickListener(state)
                val clickCount = (itemView.getTag(R.id.click_count) as Int?) ?: 0
                if (clickCount == 0) {
                    itemView.setTag(R.id.click_count, 1)
                    if (selectedState != null && selectedState != state) {
                        // Deselect previously double-clicked item if a different item is clicked
                        selectedState = null
                        notifyDataSetChanged()
                    }
                    Handler(Looper.getMainLooper()).postDelayed({
                        itemView.setTag(R.id.click_count, 0)
                    }, 300)
                } else{
                    selectedState=state
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_state, parent, false)
        return StateViewHolder(view)
    }

    override fun onBindViewHolder(holder: StateViewHolder, position: Int) {
        holder.bind(stateList[position])
    }

    override fun getItemCount(): Int = stateList.size
}

