package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.model.ChatEntity



class ChatListViewHolder(parent: ViewGroup)

    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_chat_list, parent, false)) {

    private val imgProfile: ImageView
    private val txtUserName: TextView
    private val txtUserMessage: TextView
    private val txtDate: TextView

    init {

        imgProfile = itemView.findViewById(R.id.imgProfile)
        txtUserName = itemView.findViewById(R.id.txtUserName)
        txtUserMessage = itemView.findViewById(R.id.txtUserMessage)
        txtDate = itemView.findViewById(R.id.txtDate)
    }

    fun bind(chatEntity: ChatEntity, onItemClickListener: (chatEntity: ChatEntity) -> Unit) {

        imgProfile.setBackgroundResource(chatEntity.profilePhoto)
        txtUserName.text = chatEntity.userName
        txtUserMessage.text = chatEntity.userMessage
        txtDate.text = chatEntity.date

        itemView.setOnClickListener {

            onItemClickListener(chatEntity)
        }
    }
}