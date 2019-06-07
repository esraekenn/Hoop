package io.androidedu.hoop.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.CallListAdapter
import io.androidedu.hoop.dao.CallDao
import io.androidedu.hoop.db.CallDB
import io.androidedu.hoop.model.CallEntity
import kotlinx.android.synthetic.main.fragment_calls.*
import kotlin.concurrent.thread

class CallsFragment : Fragment() {
    private val callDB: CallDB? by lazy{ CallDB.getInstance((context!!))}
    private val callDao: CallDao? by lazy { callDB?.getCallDao() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callEntity= CallEntity(0,
            R.drawable.hoop_user_icon_g,
            "Esra EKEN",
            "Today",
            "22.15",
            R.drawable.hoop_call_c,
            R.drawable.hoop_call
            )

        thread ( start=true )
        {
            callDao?.addNewCall(callEntity)
            callDao?.addNewCall(callEntity)
            callDao?.addNewCall(callEntity)
            callDao?.addNewCall(callEntity)
            callDao?.addNewCall(callEntity)
            callDao?.addNewCall(callEntity)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(recycCallList) {

            adapter = CallListAdapter { callModel ->
                thread (start=true){
                    callDao?.deleteItem(callModel)
                }

            }
            layoutManager = LinearLayoutManager(activity)
        }
        callDao?.getAllCallList()?.observe(this, Observer<List<CallEntity>>{

            (recycCallList.adapter as CallListAdapter).setNewCallList(it)
        })

    }

    companion object {
        @JvmStatic
        fun newInstance() = CallsFragment()
    }

}




