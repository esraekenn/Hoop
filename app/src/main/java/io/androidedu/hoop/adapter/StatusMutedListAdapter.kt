package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.model.CallEntity
import io.androidedu.hoop.model.StatusMutedEntity

class  StatusMutedListAdapter(var statusMutedList: List<StatusMutedEntity>?=null, val onItemClickListener: (statusMutedEntity: StatusMutedEntity) -> Unit) : RecyclerView.Adapter<StatusMutedListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusMutedListViewHolder = StatusMutedListViewHolder(parent)

    override fun getItemCount(): Int {

        statusMutedList?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: StatusMutedListViewHolder, position: Int) {
        statusMutedList?.let {
            holder.bind(it[position], onItemClickListener)
        }
    }
    fun setNewStatusMutedList(statusMutedList: List<StatusMutedEntity>)
    {
        this.statusMutedList=statusMutedList
        notifyDataSetChanged()


    }
}