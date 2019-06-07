package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.model.StatusViewedModel

class  StatusViewedListAdapter(val statusViewedList: ArrayList<StatusViewedModel>, val onItemClickListener: (statusViewedModel: StatusViewedModel) -> Unit) : RecyclerView.Adapter<StatusViewedListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewedListViewHolder = StatusViewedListViewHolder(parent)

    override fun getItemCount(): Int = statusViewedList.size

    override fun onBindViewHolder(holder: StatusViewedListViewHolder, position: Int) {

        holder.bind(statusViewedList[position], onItemClickListener)
    }
}