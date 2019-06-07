package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.model.CallEntity
import io.androidedu.hoop.model.ChatEntity

class  CallListAdapter(var callList: List<CallEntity>?=null, val onItemClickListener: (callEntity: CallEntity) -> Unit) : RecyclerView.Adapter<CallListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallListViewHolder = CallListViewHolder(parent)

    override fun getItemCount(): Int {

        callList?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: CallListViewHolder, position: Int) {
        callList?.let {
            holder.bind(it[position], onItemClickListener)
        }
    }
    fun setNewCallList(callList: List<CallEntity>)
    {
        this.callList=callList
        notifyDataSetChanged()


    }
}