package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val data = mutableListOf<User>()

    var listener: OnListItemClickListener? = null

    var listener1: ((User) -> Unit)? = null

    interface OnListItemClickListener {
        fun onClick(user: User)
    }

    fun addItem(item: User) {
        data.add(item)
        notifyItemInserted(data.size - 1)
    }

    fun setData(items: List<User>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            listener,
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class MyViewHolder(private val listener: OnListItemClickListener?, itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val textViewFirstName: TextView = itemView.findViewById(R.id.textViewFirstName)
        private val textViewLastName: TextView = itemView.findViewById(R.id.textViewLastName)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(user: User) {
            Glide.with(imageView).load(user.imageUrl).into(imageView)
            imageView.setOnClickListener {
                listener?.onClick(user)
                listener1?.invoke(user)
            }
            textViewFirstName.text = user.firstName
            textViewLastName.text = user.lastName
        }
    }

}