package io.androidedu.hoop.util

import io.androidedu.hoop.R
import io.androidedu.hoop.model.StatusViewedModel


object StatusViewedDummyData {

    fun getStatusViewedList(): ArrayList<StatusViewedModel> = ArrayList<StatusViewedModel>().apply {

        val statusViewedModel = StatusViewedModel(
            R.drawable.hoop_user_photo,
            "Esra",
            "Today"
        )
        add(statusViewedModel)
        add(statusViewedModel)


    }
}