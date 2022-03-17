package com.example.pazar4.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pazar4.Models.Oglas
import com.example.pazar4.R
import com.squareup.picasso.Picasso

class OglasAdapter(val Oglasi : MutableList<Oglas>) : RecyclerView.Adapter<OglasAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : OglasAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: OglasAdapter.ViewHolder, position: Int) {

        holder.itemTitle.text  = Oglasi[position].Name

        Picasso.get().load(Oglasi[position].thumbnail).into(holder.itemThumbnail)

    }

    override fun getItemCount(): Int {

        return Oglasi.size

    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        var itemTitle : TextView

        var itemThumbnail : ImageView

        init {

            itemTitle = view.findViewById(R.id.txtOglasTitle)

            itemThumbnail = view.findViewById(R.id.imgOglasThumbnail)

            itemThumbnail.setOnClickListener{

               // view.findNavController().navigate(R.id.SecondFragment)

                /*val bundle = Bundle()

                bundle.putString("Title", itemTitle.text.toString())

                bundle.putString("Thumbnail", )
*/
            }

        }

    }

}