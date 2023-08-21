package com.example.huedevicestesting.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.huedevicestesting.R
import com.example.huedevicestesting.retrofit.User

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    var userList : List<User> = listOf()


    inner class UserViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val idTextView : TextView
        private val nameTextView : TextView
        private val phoneTextView : TextView
        private val websiteTextView : TextView

        init {
            idTextView = view.findViewById(R.id.user_card_id_text_view)
            nameTextView = view.findViewById(R.id.user_card_name_text_view)
            phoneTextView = view.findViewById(R.id.user_card_phone_text_view)
            websiteTextView = view.findViewById(R.id.user_card_website_text_view)
        }

        fun populateCard(user : User) {
            idTextView.text = user.id.toString()
            nameTextView.text = user.name
            phoneTextView.text = user.phone
            websiteTextView.text = user.website
        }


    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_card, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersAdapter.UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.populateCard(currentUser)
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    fun setUsers(userList : List<User>) {
        this.userList = userList
        notifyItemRangeInserted(0, userList.size)
    }
}