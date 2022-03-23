package com.example.pazar4.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.pazar4.Models.Oglas
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.auth.User
import java.util.*


public class ShopViewModel (application: Application) : AndroidViewModel(application){

    val reference = FirebaseFirestore.getInstance()

    var oglasi : MutableLiveData<List <Oglas>> = MutableLiveData()

    fun getOglasi(): List<Oglas>? {



       // return listOf<Oglas>(oglas1, oglas2)
        return oglasi.value
    }

    fun findOglasById(id: Long): Oglas? {

        return oglasi.value?.find { z-> z.Id == id }
    }

    init {

         val oglas1 : Oglas = Oglas(10,"Andrej",publisherID = "kiko",thumbnail = "https://gdb.voanews.com/BB0D17A2-D48D-49F1-9AF0-9B7BB7E2F378_cx0_cy7_cw0_w1023_r1_s.jpg",
          desc = "dsakdaskdjskahda",location = "Tetovo", price = "2300",telbroj = "098765321", email = "andreeski@kikoski.com")

      val oglas2 : Oglas = Oglas(3,"Dareee",publisherID = "deko",thumbnail = "https://gdb.voanews.com/BB0D17A2-D48D-49F1-9AF0-9B7BB7E2F378_cx0_cy7_cw0_w1023_r1_s.jpg",
          desc = "epa taka sakam", location = "Ohrid", price = "5000",telbroj = "226589756", email = "vol@magare.com")

      var temp : MutableList<Oglas>? = oglasi.value as MutableList<Oglas>?

      if (temp != null) {

          temp.add(oglas1)


      }
      else{
          temp = mutableListOf<Oglas>(oglas1, oglas2)
      }

      oglasi.value = temp!!

    }

    fun addLiveData(Oglas : Oglas){

        var tmp = oglasi.value?.toMutableList()

        if (tmp != null) {

            tmp.add(Oglas)
        }
        else{
            tmp = mutableListOf<Oglas>(Oglas)
        }
        oglasi.value = tmp!!
    }
}