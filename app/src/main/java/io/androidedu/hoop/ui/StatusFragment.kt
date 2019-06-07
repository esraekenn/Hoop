package io.androidedu.hoop.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.CallListAdapter
import io.androidedu.hoop.adapter.StatusRecentListAdapter
import io.androidedu.hoop.adapter.StatusViewedListAdapter
import io.androidedu.hoop.util.StatusRecentDummyData
import io.androidedu.hoop.util.StatusViewedDummyData
import kotlinx.android.synthetic.main.fragment_chats.*
import kotlinx.android.synthetic.main.fragment_status.*


class StatusFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(recycStatusViewedList) {

            adapter = StatusViewedListAdapter(StatusViewedDummyData.getStatusViewedList()) { callModel ->

                Toast.makeText(activity, "${callModel.userName}", Toast.LENGTH_SHORT).show()
            }

            layoutManager = LinearLayoutManager(activity)
        }
        with(recycStatusRecentList) {

            adapter = StatusRecentListAdapter(StatusRecentDummyData.getStatusViewedList()) { callModel ->

                Toast.makeText(activity, "${callModel.userName}", Toast.LENGTH_SHORT).show()
            }

            layoutManager = LinearLayoutManager(activity)
        }

        with(recycStatusMutedList) {

            adapter = StatusViewedListAdapter(StatusViewedDummyData.getStatusViewedList()) { callModel ->

                Toast.makeText(activity, "${callModel.userName}", Toast.LENGTH_SHORT).show()
            }

            layoutManager = LinearLayoutManager(activity)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = StatusFragment()
            }
    }

