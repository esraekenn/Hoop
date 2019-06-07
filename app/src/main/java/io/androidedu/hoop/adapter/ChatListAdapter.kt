package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.model.ChatEntity

class  ChatListAdapter(var chatList: List<ChatEntity>?=null, val onItemClickListener: (chatEntity: ChatEntity) -> Unit) : RecyclerView.Adapter<ChatListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder = ChatListViewHolder(parent)

    override fun getItemCount(): Int {

        chatList?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        chatList?.let {
        holder.bind(it[position], onItemClickListener)
        }
    }
    fun setNewChatList(chatList: List<ChatEntity>)
    {
        this.chatList=chatList
        notifyDataSetChanged()


    }
}