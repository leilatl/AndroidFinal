package com.example.afinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*


class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var articleList = emptyList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ContactViewHolder(v)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ContactViewHolder
        val currentItem = articleList[position]
        holder.itemView.titleTextView.text = currentItem.title
        holder.itemView.authorTextView.text = currentItem.author

        holder.itemView.toDoItemLayout.setOnClickListener {
            //val action = ListFragmentDirections.navigateToDetail(position)
            //Navigation.findNavController(it).navigate(action)
            Navigation.findNavController(it).navigate(R.id.action_newsListFragment_to_newsDetailFragment)
        }
    }
    fun setData(article: List<Article>){

        this.articleList = article
        notifyDataSetChanged()
    }
    inner class ContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    }
}