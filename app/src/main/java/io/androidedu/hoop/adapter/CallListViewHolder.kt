package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.model.CallEntity


class CallListViewHolder(parent: ViewGroup)

    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_call_list, parent, false)) {

    private val imgProfile: ImageView
    private val txtUserName: TextView
    private val txtDate: TextView
    private val txtHour: TextView
    private val imgCallPhoto: ImageView
    private val imgCallSymbol: ImageView
    init {

        imgProfile = itemView.findViewById(R.id.imgProfile)
        txtUserName = itemView.findViewById(R.id.txtUserName)
        txtDate = itemView.findViewById(R.id.txtDate)
        txtHour = itemView.findViewById(R.id.txtHour)
        imgCallPhoto=itemView.findViewById(R.id.imgCallPhoto)
        imgCallSymbol=itemView.findViewById(R.id.imgCallSymbol)
    }

    fun bind(callEntity: CallEntity, onItemClickListener: (callEntity: CallEntity) -> Unit) {

        imgProfile.setBackgroundResource(callEntity.profilePhoto)
        txtUserName.text = callEntity.userName
        txtDate.text = callEntity.date
        txtHour.text=callEntity.hour
        imgCallPhoto.setBackgroundResource(callEntity.callImage)
        imgCallSymbol.setBackgroundResource(callEntity.callSymbol)

        itemView.setOnClickListener {

            onItemClickListener(callEntity)
        }
    }
}