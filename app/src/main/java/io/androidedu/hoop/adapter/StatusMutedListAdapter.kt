package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.model.StatusMutedModel
import io.androidedu.hoop.model.StatusRecentModel
import io.androidedu.hoop.model.StatusViewedModel

class  StatusMutedListAdapter(val statusMutedList: ArrayList<StatusMutedModel>, val onItemClickListener: (statusMutedModel: StatusMutedModel) -> Unit) : RecyclerView.Adapter<StatusMutedListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusMutedListViewHolder = StatusMutedListViewHolder(parent)

    override fun getItemCount(): Int = statusMutedList.size

    override fun onBindViewHolder(holder: StatusMutedListViewHolder, position: Int) {

        holder.bind(statusMutedList[position], onItemClickListener)
    }
}