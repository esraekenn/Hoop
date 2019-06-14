package io.androidedu.hoop.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.*
import io.androidedu.hoop.dao.ChatDao
import io.androidedu.hoop.dao.StatusMutedDao
import io.androidedu.hoop.dao.StatusRecentDao
import io.androidedu.hoop.dao.StatusViewedDao
import io.androidedu.hoop.db.HoopDB
import io.androidedu.hoop.db.StatusMutedDB
import io.androidedu.hoop.db.StatusRecentDB
import io.androidedu.hoop.db.StatusViewedDB
import io.androidedu.hoop.model.ChatEntity
import io.androidedu.hoop.model.StatusMutedEntity
import io.androidedu.hoop.model.StatusRecentEntity
import io.androidedu.hoop.model.StatusViewedEntity
import kotlinx.android.synthetic.main.fragment_chats.*
import kotlinx.android.synthetic.main.fragment_status.*
import kotlin.concurrent.thread


class StatusFragment : Fragment() {

    private val statusMutedDB: StatusMutedDB? by lazy{ StatusMutedDB.getInstance((context!!))}
    private val statusMutedDao:StatusMutedDao? by lazy { statusMutedDB?.getStatusMutedDao() }
    private val statusViewedDB: StatusViewedDB? by lazy{ StatusViewedDB.getInstance((context!!))}
    private val statusViewedDao: StatusViewedDao? by lazy { statusViewedDB?.getStatusViewedDao() }
    private val statusRecentDB: StatusRecentDB? by lazy{ StatusRecentDB.getInstance((context!!))}
    private val statusRecentDao: StatusRecentDao? by lazy { statusRecentDB?.getStatusRecentDao() }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val statusmMutedEntity= StatusMutedEntity(
            0,
            profilePhoto = R.drawable.hoop_user_photo,
            userName="ESRA",
            date = "YESETERDAY")
        thread ( start=true )
        {
            statusMutedDao?.addNewStatusMuted(statusmMutedEntity)
            statusMutedDao?.addNewStatusMuted(statusmMutedEntity)
            statusMutedDao?.addNewStatusMuted(statusmMutedEntity)
            statusMutedDao?.addNewStatusMuted(statusmMutedEntity)
            statusMutedDao?.addNewStatusMuted(statusmMutedEntity)
        }
        val statusViewedEntity= StatusViewedEntity(
            0,
            profilePhoto = R.drawable.hoop_user_photo,
            userName="ESRA",
            date = "YESETERDAY")
        thread ( start=true )
        {
            statusViewedDao?.addNewStatusViewed(statusViewedEntity)
            statusViewedDao?.addNewStatusViewed(statusViewedEntity)
            statusViewedDao?.addNewStatusViewed(statusViewedEntity)
            statusViewedDao?.addNewStatusViewed(statusViewedEntity)
        }
        val statusRecentEntity= StatusRecentEntity(
            0,
            profilePhoto = R.drawable.hoop_user_photo,
            userName="ESRA",
            date = "YESETERDAY")
        thread ( start=true )
        {
            statusRecentDao?.addNewStatusRecent(statusRecentEntity)
            statusRecentDao?.addNewStatusRecent(statusRecentEntity)
            statusRecentDao?.addNewStatusRecent(statusRecentEntity)
            statusRecentDao?.addNewStatusRecent(statusRecentEntity)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(recycStatusMutedList) {

            adapter = StatusMutedListAdapter { statusMutedModel ->
                thread (start=true){
                    statusMutedDao?.deleteItem(statusMutedModel)
                }

            }
            layoutManager = LinearLayoutManager(activity)
        }
        statusMutedDao?.getAllStatusMutedList()?.observe(this, Observer<List<StatusMutedEntity>>{

            (recycStatusMutedList.adapter as StatusMutedListAdapter).setNewStatusMutedList(it)
        })
        with(recycStatusViewedList) {

            adapter = StatusViewedListAdapter { statusViewedModel ->
                thread (start=true){
                    statusViewedDao?.deleteItem(statusViewedModel)
                }

            }
            layoutManager = LinearLayoutManager(activity)
        }
        statusViewedDao?.getAllStatusViewedList()?.observe(this, Observer<List<StatusViewedEntity>>{

            (recycStatusViewedList.adapter as StatusViewedListAdapter).setNewStatusViewedList(it)
        })

        with(recycStatusRecentList) {

            adapter = StatusRecentListAdapter { statusRecentModel ->
                thread (start=true){
                    statusRecentDao?.deleteItem(statusRecentModel)
                }

            }
            layoutManager = LinearLayoutManager(activity)
        }
        statusRecentDao?.getAllStatusRecentList()?.observe(this, Observer<List<StatusRecentEntity>>{

            (recycStatusRecentList.adapter as StatusRecentListAdapter).setNewStatusRecentList(it)
        })

    }

    companion object {
        @JvmStatic
        fun newInstance() = StatusFragment()
    }

}



