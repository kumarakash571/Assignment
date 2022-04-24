package com.akash.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akash.assignment.R
import com.akash.assignment.m.StoriesModel

class AuthorsAdapter(var context: Context, var mList:List<StoriesModel.Hit> ) : RecyclerView.Adapter<AuthorsAdapter.AViewHolder>(){
    class AViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
      val title = itemView.findViewById<TextView>(R.id.title)
        val author = itemView.findViewById<TextView>(R.id.author_name)
        val date = itemView.findViewById<TextView>(R.id.date)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AViewHolder {
        return AViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_users,parent,false))
    }

    override fun onBindViewHolder(holder: AViewHolder, position: Int) {
        holder.title.text = mList[position].storyTitle.toString()
        holder.author.text = mList[position].author.toString()
        holder.date.text = mList[position].createdAt.toString()
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    fun setData(mList: List<StoriesModel.Hit>){
        this.mList = mList
    }
}