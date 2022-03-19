package com.example.pazar4.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.pazar4.Models.Oglas

public class ShopViewModel (application: Application) : AndroidViewModel(application){

    val oglasi : MutableLiveData<List <Oglas>> = MutableLiveData()

    fun getOglasi(): List<Oglas>? {

        val oglas2 : Oglas = Oglas(3,"dareee",publisherID = "deko",thumbnail = "https://gdb.voanews.com/BB0D17A2-D48D-49F1-9AF0-9B7BB7E2F378_cx0_cy7_cw0_w1023_r1_s.jpg",
            desc = "epa taka sakam", location = "Ohrid", price = "5000",telbroj = "226589756", email = "vol@magare.com")

       // return listOf<Oglas>(oglas1, oglas2)
        return oglasi.value
    }

    init {

        val oglas1 : Oglas = Oglas(10,"andrej",publisherID = "kiko",thumbnail = "https://gdb.voanews.com/BB0D17A2-D48D-49F1-9AF0-9B7BB7E2F378_cx0_cy7_cw0_w1023_r1_s.jpg",
            desc = "dsakdaskdjskahda",location = "Tetovo", price = "2300",telbroj = "098765321", email = "andreeski@kikoski.com")

        var temp : MutableList<Oglas>? = oglasi.value as MutableList<Oglas>?

        if (temp != null) {

            temp.add(oglas1)

        }

        oglasi.value = temp!!

    }
}