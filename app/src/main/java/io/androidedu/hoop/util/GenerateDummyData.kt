package io.androidedu.hoop.util

import io.androidedu.hoop.model.ChatEntity
import io.androidedu.hoop.R


object GenerateDummyData {

    fun getDummyChatList(): ArrayList<ChatEntity> = ArrayList<ChatEntity>().apply {

        val chatModel = ChatEntity(
            55,
            R.drawable.hoop_camera,
            "Esra",
            "Noldu ya foton gitti",
            "22.15"
        )

        add(chatModel)
        add(chatModel)

    }
}