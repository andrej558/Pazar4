package com.example.pazar4.Models

import com.google.type.DateTime
import java.util.*

data class Oglas(val Id : Long,val Name : String,val createDate : Date,
val publisherID : String,val thumbnail : String,val desc : String)
