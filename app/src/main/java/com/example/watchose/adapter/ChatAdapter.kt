package com.example.watchose.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.watchose.Chat
import com.example.watchose.R
import com.example.watchose.databinding.ChatBinding

class ChatAdapter :
    RecyclerView.Adapter<ChatAdapter.ChatHolder>() {

    val chatList = ArrayList<Chat>()

    class ChatHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ChatBinding.bind(item)
        fun bind(chat: Chat) = with(binding) {
            ChatName.text = chat.chatName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat, parent, false)
        return ChatHolder(view)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        holder.bind(chatList[position])
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    fun addChats(list: List<Chat>) {
        chatList.clear()
        chatList.addAll(list)
        notifyDataSetChanged()
    }
}