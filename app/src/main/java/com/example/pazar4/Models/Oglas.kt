package com.example.pazar4.Models

import android.location.Location
import com.google.type.DateTime
import java.time.LocalDateTime
import java.util.*

data class Oglas(val Id : Long,val Name : String,val createDate : Date?=Calendar.getInstance().time,
val publisherID : String,val thumbnail : String,val desc : String, val location : String,
val price : String,val telbroj : String,val email : String){


}
