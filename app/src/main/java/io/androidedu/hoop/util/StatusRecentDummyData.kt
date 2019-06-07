package io.androidedu.hoop.util

import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.StatusRecentListViewHolder
import io.androidedu.hoop.model.StatusRecentModel
import io.androidedu.hoop.model.StatusViewedModel


object StatusRecentDummyData {

    fun getStatusViewedList(): ArrayList<StatusRecentModel> = ArrayList<StatusRecentModel>().apply {

        val statusRecentModel = StatusRecentModel(
            R.drawable.hoop_user_photo,
            "Esra",
            "Today"
        )
        add(statusRecentModel)
        add(statusRecentModel)


    }
}