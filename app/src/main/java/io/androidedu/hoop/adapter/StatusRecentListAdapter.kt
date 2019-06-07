package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.model.StatusRecentModel
import io.androidedu.hoop.model.StatusViewedModel

class  StatusRecentListAdapter(val statusRecentList: ArrayList<StatusRecentModel>, val onItemClickListener: (statusRecentModel: StatusRecentModel) -> Unit) : RecyclerView.Adapter<StatusRecentListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusRecentListViewHolder = StatusRecentListViewHolder(parent)

    override fun getItemCount(): Int = statusRecentList.size

    override fun onBindViewHolder(holder: StatusRecentListViewHolder, position: Int) {

        holder.bind(statusRecentList[position], onItemClickListener)
    }
}