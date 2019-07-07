package io.androidedu.hoop.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.db.HoopDB
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.ChatListAdapter
import io.androidedu.hoop.dao.ChatDao
import io.androidedu.hoop.model.ChatEntity
import kotlinx.android.synthetic.main.fragment_chats.*
import kotlin.concurrent.thread

class ChatsFragment : Fragment() {
    private val hoopDB: HoopDB? by lazy{ HoopDB.getInstance((context!!))}
    private val chatDao:ChatDao? by lazy { hoopDB?.getChatDao() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val chatEntity=ChatEntity(
            profilePhoto = R.drawable.user_photo_girl5,
            userName="Bestt",
            userMessage = "Merhaba,yaz mevsimi gerçekten çok berbat bıktımm",
            date = "Dün")
        val chatEntity2=ChatEntity(
            profilePhoto = R.drawable.user_photo_girl1,
            userName="My dear..",
            userMessage = "Selamlar,kış mevsimi bir şaheserdir Norveç'e taşınalım ",
            date = "16.19")
        val chatEntity3=ChatEntity(
            profilePhoto = R.drawable.user_photo_girl2,
            userName="Honeyyyy!",
            userMessage = "Selamlar,kış mevsimi bir şaheserdir Norveç'e taşınalım ",
            date = "16.24")
        val chatEntity4=ChatEntity(
            profilePhoto = R.drawable.user_photo_girl3,
            userName="Cow",
            userMessage = "Selamlar,kış mevsimi bir şaheserdir Norveç'e taşınalım ",
            date = "17.29")
        thread ( start=true )
        {
            chatDao?.addNewChat(chatEntity)
            //chatDao?.addNewChat(chatEntity2)
            //chatDao?.addNewChat(chatEntity3)
            chatDao?.addNewChat(chatEntity4)

        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            with(recycChatList) {

                adapter = ChatListAdapter {chatModel ->
                    thread (start=true){
                        chatDao?.deleteItem(chatModel)
                }

                }
                layoutManager = LinearLayoutManager(activity)
             }
        chatDao?.getAllChatList()?.observe(this, Observer<List<ChatEntity>>{

            (recycChatList.adapter as ChatListAdapter).setNewChatList(it)
    })

        }

    companion object {
        @JvmStatic
        fun newInstance() = ChatsFragment()
    }

}




