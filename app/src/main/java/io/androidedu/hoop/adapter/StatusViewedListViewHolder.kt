package io.androidedu.hoop.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
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

    fun bind(statusViewedModel: StatusViewedModel, onItemClickListener: (statusViewModel: StatusViewedModel) -> Unit) {

        imgProfile.setBackgroundResource(statusViewedModel.profilePhoto)
        txtUserName.text = statusViewedModel.userName
        txtDate.text = statusViewedModel.date
        itemView.setOnClickListener {

            onItemClickListener(statusViewedModel)
        }
    }
}