package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.model.StatusMutedEntity
import io.androidedu.hoop.model.StatusRecentEntity
import io.androidedu.hoop.model.StatusRecentModel
import io.androidedu.hoop.model.StatusViewedModel

class  StatusRecentListAdapter(var statusRecentList: List<StatusRecentEntity>?=null, val onItemClickListener: (statusRecentEntity: StatusRecentEntity) -> Unit) : RecyclerView.Adapter<StatusRecentListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusRecentListViewHolder = StatusRecentListViewHolder(parent)

    override fun getItemCount(): Int {

        statusRecentList?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: StatusRecentListViewHolder, position: Int) {
        statusRecentList?.let {
            holder.bind(it[position], onItemClickListener)
        }
    }
    fun setNewStatusRecentList(statusRecentList: List<StatusRecentEntity>)
    {
        this.statusRecentList=statusRecentList
        notifyDataSetChanged()


    }
}