package com.example.pazar4.Models

import android.location.Location
import com.google.type.DateTime
import java.util.*

data class Oglas(val Id : Long,val Name : String,val createDate : Date,
val publisherID : String,val thumbnail : String,val desc : String, val location : Location,
val price : String,val telbroj : String,val email : String)
