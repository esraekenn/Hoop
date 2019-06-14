package io.androidedu.hoop.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.model.StatusMutedEntity


class StatusMutedListViewHolder(parent: ViewGroup)

    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_status_muted, parent, false)) {

    private val imgProfile: ImageView
    private val txtUserName: TextView
    private val txtDate: TextView

    init {

        imgProfile = itemView.findViewById(R.id.imgUserProfile)
        txtUserName = itemView.findViewById(R.id.txtUserName)
        txtDate = itemView.findViewById(R.id.txtDate)

    }

    fun bind(statusMutedEntity: StatusMutedEntity, onItemClickListener: (statusMutedEntity: StatusMutedEntity) -> Unit) {

        imgProfile.setBackgroundResource(statusMutedEntity.profilePhoto)
        txtUserName.text = statusMutedEntity.userName
        txtDate.text = statusMutedEntity.date

        itemView.setOnClickListener {

            onItemClickListener(statusMutedEntity)
        }
    }
}