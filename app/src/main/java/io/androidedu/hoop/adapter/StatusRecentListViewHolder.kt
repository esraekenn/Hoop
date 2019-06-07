package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.model.StatusRecentModel
import io.androidedu.hoop.model.StatusViewedModel

class StatusRecentListViewHolder(parent: ViewGroup)

    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_status_recent, parent, false)) {

    private val imgProfile: ImageView
    private val txtUserName: TextView
    private val txtDate: TextView
    init {

        imgProfile = itemView.findViewById(R.id.imgUserProfile)
        txtUserName = itemView.findViewById(R.id.txtUserName)
        txtDate = itemView.findViewById(R.id.txtDate)

    }

    fun bind(statusRecentModel: StatusRecentModel, onItemClickListener: (statusRecentModel: StatusRecentModel) -> Unit) {

        imgProfile.setBackgroundResource(statusRecentModel.profilePhoto)
        txtUserName.text = statusRecentModel.userName
        txtDate.text = statusRecentModel.date
        itemView.setOnClickListener {

            onItemClickListener(statusRecentModel)
        }
    }
}