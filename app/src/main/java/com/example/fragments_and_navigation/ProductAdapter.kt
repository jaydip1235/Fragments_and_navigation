package com.example.fragments_and_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class ProductAdapter( private val shoppingItem: List<Product>) : RecyclerView.Adapter<ProductAdapter.ShopViewHolder>(){

    class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.name)
        val price : TextView = itemView.findViewById(R.id.price)
        val image : ImageView = itemView.findViewById(R.id.image)
        val description : TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        return ShopViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return shoppingItem.size
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val currentItem = shoppingItem[position]

        holder.image.setImageResource(currentItem.imageId)
        holder.name.text = currentItem.name
        holder.price.text = currentItem.price.toString()
        holder.description.text = currentItem.shortDescription


        holder.itemView.setOnClickListener {view->
          //val bundle = Bundle()
         // bundle.putInt("ID", shoppingItem[position].id)
          view.findNavController().navigate(ListFragmentDirections.actionHomeToDetail( shoppingItem[position].id))

        }
    }
}