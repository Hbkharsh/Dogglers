package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.data.DataSource

class DogCardAdapter(
    private val context: Context?,
    private val layout:Int,

    ):RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
    private val dogList = DataSource.dogs

    class DogCardViewHolder(view: View?):RecyclerView.ViewHolder(view!!){
        val imageView:ImageView = view!!.findViewById(R.id.imageView2)
        val textView1:TextView = view!!.findViewById(R.id.dog_name)
        val textView2:TextView = view!!.findViewById(R.id.dog_age)
        val textView3:TextView = view!!.findViewById(R.id.dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
     val adapterLayout = when(layout){
         GRID -> LayoutInflater.from(parent.context)
             .inflate(R.layout.grid_list_item,parent,false)

         else -> LayoutInflater.from(parent.context)
             .inflate(R.layout.vertical_horizontal_list_item,parent,false)
     }
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
       return dogList.size
    }

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val item = dogList[position]
        holder.imageView.setImageResource(item.imageResourceID)
        holder.textView1.text = item.name
        val resources = context?.resources
        holder.textView2.text =resources?.getString(R.string.dog_age,item.age)
        holder.textView3.text = resources?.getString(R.string.dog_hobbies,item.hobbies)
    }
}