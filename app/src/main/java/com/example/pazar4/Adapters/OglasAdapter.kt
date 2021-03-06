package com.example.pazar4.Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pazar4.BasicActivity
import com.example.pazar4.Models.Oglas
import com.example.pazar4.R
import com.example.pazar4.ViewModels.ShopViewModel
import com.squareup.picasso.Picasso

class OglasAdapter(val Oglasi : MutableList<Oglas>, val context: Context?) : RecyclerView.Adapter<OglasAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : OglasAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: OglasAdapter.ViewHolder, position: Int) {

        holder.itemTitle.text  = Oglasi[position].Name

        Picasso.get().load(Oglasi[position].thumbnail).into(holder.itemThumbnail)

        holder.oglasId = Oglasi[position].Id



    }

    override fun getItemCount(): Int {

        return Oglasi.size

    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        var oglasId : Long = 0

        var itemTitle : TextView

        var itemThumbnail : ImageView


        init {


            itemTitle = view.findViewById(R.id.txtOglasTitle)

            itemThumbnail = view.findViewById(R.id.imgOglasThumbnail)

            itemThumbnail.setOnClickListener{

               //BasicActivity.displayText(view.context)

                /*(view.context as BasicActivity).FetchOglasById(oglasId)*/

                val bundle = bundleOf("oglasId" to oglasId)

               view.findNavController().navigate(R.id.SecondFragment, bundle)
/*
                //(context as BasicActivity).FetchOglasById(oglasId)
                val bundle = Bundle()

                bundle.putString("Title", itemTitle.text.toString())

                bundle.putString("Thumbnail", )*/

            }

        }

    }

}