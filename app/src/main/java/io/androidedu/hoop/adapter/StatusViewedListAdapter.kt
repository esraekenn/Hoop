package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.model.StatusMutedEntity
import io.androidedu.hoop.model.StatusViewedEntity
import io.androidedu.hoop.model.StatusViewedModel

class  StatusViewedListAdapter(var statusViewedList: List<StatusViewedEntity>?=null, val onItemClickListener: (statusViewedEntity: StatusViewedEntity) -> Unit) : RecyclerView.Adapter<StatusViewedListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewedListViewHolder = StatusViewedListViewHolder(parent)

    override fun getItemCount(): Int {

        statusViewedList?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: StatusViewedListViewHolder, position: Int) {
        statusViewedList?.let {
            holder.bind(it[position], onItemClickListener)
        }
    }
    fun setNewStatusViewedList(statusViewedList: List<StatusViewedEntity>)
    {
        this.statusViewedList=statusViewedList
        notifyDataSetChanged()


    }
}