package io.androidedu.hoop.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.model.StatusViewedEntity
import io.androidedu.hoop.model.StatusViewedModel


class StatusViewedListViewHolder(parent: ViewGroup)

    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_status_viewed, parent, false)) {

    private val imgProfile: ImageView
    private val txtUserName: TextView
    private val txtDate: TextView
    init {

        imgProfile = itemView.findViewById(R.id.imgUserProfile)
        txtUserName = itemView.findViewById(R.id.txtUserName)
        txtDate = itemView.findViewById(R.id.txtDate)

    }

    fun bind(statusViewedEntity: StatusViewedEntity, onItemClickListener: (statusViewedEntity: StatusViewedEntity) -> Unit) {

        imgProfile.setBackgroundResource(statusViewedEntity.profilePhoto)
        txtUserName.text = statusViewedEntity.userName
        txtDate.text = statusViewedEntity.date
        itemView.setOnClickListener {

            onItemClickListener(statusViewedEntity)
        }
    }
}